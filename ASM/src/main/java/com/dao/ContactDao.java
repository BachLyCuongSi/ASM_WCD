package com.dao;

import com.model.ContactEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContactDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insertContact(ContactEntity contact){
        try{
            if(!contact.getEmail().isEmpty() && !contact.getName().isEmpty() && !contact.getSubject().isEmpty() && !contact.getMessage().isEmpty()){
                em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(contact);
                em.getTransaction().commit();
                em.close();
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
