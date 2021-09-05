package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Classes;

public class ClassesOperationDao {

	public void SaveClassDetails(Classes classesdtl){
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           
            session.save(classesdtl);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
	}
	
	public List<Classes> getAllClasses(){
		List<Classes> classList= null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           classList=session.createQuery("from Classes").getResultList();
           
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return classList;
	}
	public Classes getClassbyName(String name){
		List<Classes> c1=null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // save the class object
            c1=session.createQuery("from Classes where className= '"+name+"'").getResultList();
           
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return c1.get(0);
	}

}
