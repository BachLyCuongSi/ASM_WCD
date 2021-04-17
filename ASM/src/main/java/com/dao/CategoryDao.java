package com.dao;

import com.model.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();
    public void insertCategory(CategoryEntity cate){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cate);
        em.getTransaction().commit();
        em.close();
    }
    public List<CategoryEntity> listCate(){
        List<CategoryEntity> list = new ArrayList<>();
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            list = em.createQuery("select p from CategoryEntity p order by p.id ASC ", CategoryEntity.class).setMaxResults(6).getResultList();
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return list;
    }

    public List<CategoryEntity> listCategory(){
        List<CategoryEntity> list = new ArrayList<>();
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            list = em.createQuery("select p from CategoryEntity p order by p.id ASC ", CategoryEntity.class).getResultList();
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return list;
    }
    public boolean deleteCate(int id) {
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            CategoryEntity p = em.find(CategoryEntity.class, id);
            if (p != null) {
                em.remove(p);
                em.getTransaction().commit();
            }
            em.close();
            return true;
        }catch (Exception ex){
            return false;
        }

    }

    public boolean updateCate(CategoryEntity cate){
//        try{
        em = emf.createEntityManager();
        em.getTransaction().begin();
        CategoryEntity c = em.find(CategoryEntity.class, cate.getId());
        if (c != null) {
            c.setName(cate.getName());
            c.setTitle(cate.getTitle());
            c.setUrl_image(cate.getUrl_image());

            em.getTransaction().commit();
            em.close();
        }
//        }catch (Exception ex){
//            System.out.println(ex.toString());
//        }
//        em.getTransaction().rollback();
        em.close();
        return false;
    }

    public List<CategoryEntity> getlistCategory(int  page ,int limit){
        List<CategoryEntity>  list  = new ArrayList<>();
        limit =  1;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createQuery("select p from CategoryEntity p order by p.id ASC ", CategoryEntity.class)
                .setFirstResult(page*limit+1)
                .setMaxResults(limit)
                .getResultList();
        em.getTransaction().commit();
        em.close();

        return list;
    }
}
