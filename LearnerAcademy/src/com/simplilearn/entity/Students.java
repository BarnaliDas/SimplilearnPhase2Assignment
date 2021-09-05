package com.simplilearn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="la_student_master")
public class Students {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lastm_id")
	 int id;
	
	@Column(name="lastm_student_name")
	 String studentName;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch=FetchType.LAZY)
	@JoinColumn(name="lastm_class_id")
	Classes studentClasses;
	
	public Students(){
		
	}

	public Students(String studentName) {
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public Classes getClasses() {
		return studentClasses;
	}

	public void setClasses(Classes classes) {
		this.studentClasses = classes;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", studentName=" + studentName  + "]";
	}
	
}
