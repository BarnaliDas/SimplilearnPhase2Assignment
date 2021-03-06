package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Classes;
import com.simplilearn.entity.SubjectClassMap;
import com.simplilearn.entity.TeacherSubjectMap;
import com.simplilearn.entity.Teachers;

public class TeacherSubjectClassOperationDao {
	
	public void saveTeacherSubjectMapping(Teachers teacher,SubjectClassMap subClass ){
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           
            TeacherSubjectMap tsm = new TeacherSubjectMap(teacher, subClass);
            session.save(tsm);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

	public List<Teachers> getTeacherforClassName(Classes classes){
		List<Teachers> t=null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            
            t=session.createQuery("from TeacherSubjectMap  where scm in( select id from SubjectClassMap where subject = '"+classes.getClassName()+"')").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); 
            }
            e.printStackTrace();
        }
		
		
		return t;
	}
}
