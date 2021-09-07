package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassesOperationDao;
import com.simplilearn.dao.SubjectOperationsDao;
import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Students;
import com.simplilearn.entity.Subjects;

/**
 * Servlet implementation class GetDetailSubjectClass
 */
public class GetDetailSubjectClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private SubjectOperationsDao sod;
      private ClassesOperationDao cod;
    /**
     * @see HttpServlet#HttpServlet()
     */
      
      public void init(){
    	  sod=new SubjectOperationsDao();
    	  cod=new ClassesOperationDao();
      }
    public GetDetailSubjectClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		populateSubjectandClasses(request,response);
	}

	public void populateSubjectandClasses(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	    try {
		 List < Subjects > subjectList = sod.getAllSubjects();
		 List< Classes> classesList= cod.getAllClasses();
	        request.setAttribute("subjectList", subjectList);
	        request.setAttribute("classesList", classesList);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("subject-class-map.jsp");
	        dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		populateSubjectandClasses(request,response);
	}

}
