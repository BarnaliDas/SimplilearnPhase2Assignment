package com.simplilearn.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Students;
import com.simplilearn.entity.SubjectClassMap;
import com.simplilearn.entity.Subjects;
import com.simplilearn.entity.TeacherSubjectMap;
import com.simplilearn.entity.Teachers;

public class HibernateConfiguration {

	 private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/simplilearn?allowPublicKeyRetrieval=true&useSSL=false");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "Admin@2021");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	   //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	    configuration.setProperties(settings);
	    
	    configuration.addAnnotatedClass(Classes.class).addAnnotatedClass(Subjects.class)
	    .addAnnotatedClass(Students.class).addAnnotatedClass(Teachers.class).
	    addAnnotatedClass(SubjectClassMap.class).addAnnotatedClass(TeacherSubjectMap.class);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }


}
