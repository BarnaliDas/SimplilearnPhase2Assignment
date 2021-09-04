package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LA_Subject_Master")
public class Subjects {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="lasm_id")
	 private int lasm_id;
	 
	 @Column(name="lasm_subject_name")
	 private String lasm_subject_name;

	public Subjects() {
		}

	public Subjects(int lasm_id, String lasm_subject_name) {
		super();
		this.lasm_id = lasm_id;
		this.lasm_subject_name = lasm_subject_name;
	}

	public int getLasm_id() {
		return lasm_id;
	}

	public void setLasm_id(int lasm_id) {
		this.lasm_id = lasm_id;
	}

	public String getLasm_subject_name() {
		return lasm_subject_name;
	}

	public void setLasm_subject_name(String lasm_subject_name) {
		this.lasm_subject_name = lasm_subject_name;
	}
	 
	 
	 
}
