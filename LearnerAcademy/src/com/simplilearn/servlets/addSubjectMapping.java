package com.simplilearn.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassesOperationDao;
import com.simplilearn.dao.SubjectClassOperationDao;
import com.simplilearn.dao.SubjectOperationsDao;
import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Subjects;

/**
 * Servlet implementation class addSubjectMapping
 */
public class addSubjectMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private SubjectClassOperationDao scod;
	 private SubjectOperationsDao sod;
     private ClassesOperationDao cod;
 
   
	public void init(){
		scod=new SubjectClassOperationDao();
		sod=new SubjectOperationsDao();
	   	  cod=new ClassesOperationDao();
	   
	}
    public addSubjectMapping() {
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
		   try {
		if(request.getParameter("subject")!=null && !("").equals(request.getParameter("subject"))&& request.getParameter("classes")!=null && !("").equals(request.getParameter("classes"))){
			Subjects subjectdtl=sod.getSubjectsbyName( request.getParameter("subject"));
			Classes classdtl=cod.getClassbyName(request.getParameter("classes"));
			savecount=scod.saveSubjectClassMapping(subjectdtl, classdtl);
		}
		if(savecount>0){
			String successMsg="Subject mapped to class successfully";
	        request.setAttribute("successMsg", successMsg);
	      /*  GetDetailSubjectClass gt=new GetDetailSubjectClass();
	        gt.doGet(request, response);*/
	       RequestDispatcher dispatcher = request.getRequestDispatcher("subject-class-map.jsp");
	     
				dispatcher.forward(request, response);
			
	        }
	else{
		 String failureMsg="Sorry,this mapping already exist";
	        request.setAttribute("failureMsg", failureMsg);
	       /* GetDetailSubjectClass gt=new GetDetailSubjectClass();
	        gt.doGet(request, response);*/
	        RequestDispatcher dispatcher = request.getRequestDispatcher("subject-class-map.jsp");
	        dispatcher.forward(request, response);
		}
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
	}

}
