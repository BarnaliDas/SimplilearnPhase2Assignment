package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.config.HibernateConfiguration;
import com.simplilearn.entity.Students;

public class StudentOperationDao {

	public void SaveStudentDetails(Students studentdtl){
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
           
            session.save(studentdtl);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
	}
	
	public List<Students> getAllStudents(){
		List<Students> studentList= null;
		Transaction transaction = null;
        try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            studentList=session.createQuery("from Students").getResultList();
           // System.out.println(studentList.get(0).getStudentName()+" :: "+studentList.get(0).getClasses().getClassName());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(studentList.size()>0){
        	for(Students std:studentList){
        		 System.out.println(std.getStudentName()+" :: "+std.getStudentClasses().getClassName());
        	}
        }
		return studentList;
	}


	public List<Students> getClasswiseSutdents(int classId){
		List<Students> studentList= null;
		Transaction transaction = null;
		try {
            // start a transaction
        	Session session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // save the class object
            studentList=session.createQuery("from Students where lastm_class_id ="+classId).getResultList();
           
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return studentList;
	}


}
