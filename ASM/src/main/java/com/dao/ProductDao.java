package com.dao;

import com.model.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<ProductEntity> getlistProduct(int cateid ){
        List<ProductEntity> list = new ArrayList<>();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        if(cateid > 0){
            list = em.createQuery("select p from ProductEntity p where p.is_active = true  and p.category_id = "+cateid +" order by p.id desc ", ProductEntity.class).getResultList();
        }else {
            list = em.createQuery("select p from ProductEntity p where p.is_active = true  order by p.id desc", ProductEntity.class).getResultList();
        }
        em.getTransaction().commit();
        em.close();

        return list;
    }
    public List<ProductEntity> getlistProductHome( ){
        List<ProductEntity> list = new ArrayList<>();
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            list = em.createQuery("select p from ProductEntity p where p.is_active = true  order by p.id desc", ProductEntity.class).setMaxResults(8).getResultList();
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return list;
    }

    public ProductEntity producDetail(int id){
        ProductEntity product = new ProductEntity();
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            product = em.createQuery("select p from ProductEntity p where p.is_active = true  and p.id = "+id, ProductEntity.class).getSingleResult();
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return product;
    }
}
