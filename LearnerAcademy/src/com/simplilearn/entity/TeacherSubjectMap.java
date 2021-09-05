package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="la_teacher_subject_mapping")
public class TeacherSubjectMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="latsm_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name="latsm_teacher_id")
	Teachers teachers;
	
	@OneToOne
	@JoinColumn(name="latsm_subject_class_map_id")
	SubjectClassMap scm;

	public TeacherSubjectMap() {
	
	}

	public TeacherSubjectMap(Teachers teachers, SubjectClassMap scm) {
		this.teachers = teachers;
		this.scm = scm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public SubjectClassMap getScm() {
		return scm;
	}

	public void setScm(SubjectClassMap scm) {
		this.scm = scm;
	}
	

}
