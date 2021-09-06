package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Subjects;

public class SubjectOperationsDao {

	public int SaveSubjectDetails(Subjects subjectdtl){
		int savecount=0;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           
            session.save(subjectdtl);
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
	
	public List<Subjects> getAllSubjects(){
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

	public Subjects getSubjectsbyName(String name){
		List<Subjects> subjectList= null;
		Subjects s1=null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            subjectList=session.createQuery("from Subjects where subjectName= '"+name+"'").getResultList();
           
            // commit transaction
            transaction.commit();
            if(subjectList.size()>0){
            	s1=	subjectList.get(0);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return s1;
	}

}
