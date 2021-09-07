package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Classes;
import com.simplilearn.entity.SubjectClassMap;
import com.simplilearn.entity.Subjects;
import com.simplilearn.entity.Teachers;

public class SubjectClassOperationDao {

	
	public int saveSubjectClassMapping(Subjects sub, Classes classes){
		int save=0;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           
           SubjectClassMap scm = new SubjectClassMap(classes,sub);
            session.save(scm);
            // commit transaction
            transaction.commit();
            save=1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
          //  e.printStackTrace();
            save=0;
        }
      return save;  
	}
	
	
	public List<Subjects> getSubjectsForClassMapping(Classes classes){
		List<Subjects> subjectList=null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            subjectList=session.createQuery("from SubjectClassMap  where classname ="+classes.getId()).getResultList();
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
