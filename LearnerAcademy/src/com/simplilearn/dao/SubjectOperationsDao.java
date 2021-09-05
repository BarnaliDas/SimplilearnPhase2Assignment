package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Subjects;

public class SubjectOperationsDao {

	public void SaveSubjectDetails(Subjects subjectdtl){
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           
            session.save(subjectdtl);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
	}
	
	public List<Subjects> getAllClasses(){
		List<Subjects> subjectList= null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            subjectList=session.createQuery("from Subjects").getResultList();
           
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return subjectList;
	}



}
