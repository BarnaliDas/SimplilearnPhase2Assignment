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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="la_teacher_master")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="latm_id")
	 int id;
	
	@Column(name="latm_teacher_name")
	 String teacherName;
	
	@OneToMany(mappedBy ="teachers")
	List<TeacherSubjectMap> teacherSubjectMap;
	
	public Teachers(){
		
	}

	public Teachers(String teacherName) {
		super();
		this.teacherName = teacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<TeacherSubjectMap> getTeacherSubjectMap() {
		return teacherSubjectMap;
	}

	public void setTeacherSubjectMap(List<TeacherSubjectMap> teacherSubjectMap) {
		this.teacherSubjectMap = teacherSubjectMap;
	}

	

	
	
}
