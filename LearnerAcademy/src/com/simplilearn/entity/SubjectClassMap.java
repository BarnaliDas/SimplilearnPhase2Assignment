package com.simplilearn.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="la_sub_class_mapping")
public class SubjectClassMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	@JoinColumn(name="lascm_class_id")
	Classes classname;
	
	@ManyToOne
	@JoinColumn(name="lascm_subject_id")
	Subjects subject;
	
	@ManyToOne
	@JoinColumn(name="lascm_teacher_id")
	Teachers teachers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Classes getClassname() {
		return classname;
	}

	public void setClassname(Classes classname) {
		this.classname = classname;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	
	

}
