package com.simplilearn.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.SubjectOperationsDao;
import com.simplilearn.entity.Subjects;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/saveSubject")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SubjectOperationsDao sod;
       public void init(){
    	   sod= new SubjectOperationsDao();
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int savecount=0;
		if(request.getParameter("subName")!=null && !("").equals(request.getParameter("subName"))){
			Subjects subjectdtl= new Subjects(request.getParameter("subName"));
			savecount=sod.SaveSubjectDetails(subjectdtl);
		}
		if(savecount>0){
			String successMsg="New Subject added to master";
	        request.setAttribute("successMsg", successMsg);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("add-subject-master.jsp");
	        dispatcher.forward(request, response);
	        }
	else{
		 String failureMsg="Sorry, This Subject already exist";
	        request.setAttribute("failureMsg", failureMsg);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("add-subject-master.jsp");
	        dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
