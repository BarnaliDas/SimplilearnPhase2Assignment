package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Teachers;

public class TeachersOperationDao {

	public int SaveTeacherDetails(Teachers teacherdtl){
		int savecount=0;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            session.save(teacherdtl);
            // commit transaction
            transaction.commit();
            savecount=1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
          //  e.printStackTrace();
            savecount=0;
        }
       return savecount; 
	}
	
	public List<Teachers> getAllTeachers(){
		List<Teachers> teacherList= null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            teacherList=session.createQuery("from Teachers").getResultList();
           
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return teacherList;
	}



}
