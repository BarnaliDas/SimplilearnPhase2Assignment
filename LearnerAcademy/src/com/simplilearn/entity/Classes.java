package com.simplilearn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="la_class_master")
public class Classes {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lacm_id")
	 int id;
	
	@Column(name="lacm_class_name")
	 String className;
	
	@OneToMany(mappedBy="classes")
	List<Students> studentlist;
	
	@OneToMany(mappedBy="classes")
	 List<Subjects> subjects;
	
	@OneToMany(mappedBy="classname")
	List<SubjectClassMap> subjectClassMap;
	
	public Classes(){
		
	}

	public Classes(String className) {
		this.className = className;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", className=" + className + "]";
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	public void addStudent(Students students){
		if(studentlist == null){
			studentlist=new ArrayList<Students>();
		}
		studentlist.add(students);
		students.setClasses(this);
	}

	public List<Students> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Students> studentlist) {
		this.studentlist = studentlist;
	}

	public List<SubjectClassMap> getSubjectClassMap() {
		return subjectClassMap;
	}

	public void setSubjectClassMap(List<SubjectClassMap> subjectClassMap) {
		this.subjectClassMap = subjectClassMap;
	}
}
