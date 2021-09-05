package com.simplilearn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="la_subject_master")
public class Subjects {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="lasm_id")
	  int id;
	 
	 @Column(name="lasm_subject_name")
	  String subjectName;
	
	 @OneToMany(mappedBy="subject")
	 List<SubjectClassMap> subjectClassMap;
	 
	public Subjects() {
		}

	public Subjects(String subjectName) {
		
		this.subjectName = subjectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
		@Override
		public String toString() {
			return "Subjects [id=" + id + ", subjectName=" + subjectName + "]";
		}

		public List<SubjectClassMap> getSubjectClassMap() {
			return subjectClassMap;
		}

		public void setSubjectClassMap(List<SubjectClassMap> subjectClassMap) {
			this.subjectClassMap = subjectClassMap;
		}
	 

	 
}
