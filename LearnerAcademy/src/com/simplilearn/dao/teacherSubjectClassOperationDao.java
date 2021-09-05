package com.simplilearn.dao;

import java.util.List;

import com.simplilearn.entity.Subjects;
import com.simplilearn.entity.Teachers;

public class teacherSubjectClassOperationDao {

	public void saveSubjectClassMapping(int subjectId, int classId){
		
	}
	
	public void saveSubjectwiseTeacherMapping(int subjectId, int classId, int teacherId){
		
	}
	
	public List<Subjects> getSubjectsForClassMapping(int classId){
		List<Subjects> subjectList=null;
		
		return subjectList;
	}
	
	public List<Teachers> getTeachersForClassMapping(int classId){
		List<Teachers> teacherList=null;
		
		return teacherList;
	}
}
