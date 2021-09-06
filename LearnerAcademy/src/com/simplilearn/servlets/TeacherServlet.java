package com.simplilearn.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.TeachersOperationDao;
import com.simplilearn.entity.Teachers;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/saveClass")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private TeachersOperationDao tod;
	public void init(){
		tod=new TeachersOperationDao();
	}
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int count=0;
		if(request.getParameter("teacherName")!=null && !("").equals(request.getParameter("teacherName"))){
			count=saveTeacherDetails(request,response);
		}
		if(count>0){
	        String successMsg="New Teacher added to master";
	        request.setAttribute("successMsg", successMsg);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("add-tacher-master.jsp");
	        dispatcher.forward(request, response);
	        }
	else{
		 String failureMsg="Sorry, Teacher already exist with this Name";
	        request.setAttribute("failureMsg", failureMsg);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("add-teacher-master.jsp");
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

	private int saveTeacherDetails(HttpServletRequest request, HttpServletResponse response){
		int savecount=0;
		Teachers teacherdtl= new Teachers(request.getParameter("teacherName"));
		savecount=tod.SaveTeacherDetails(teacherdtl);
		return savecount;
	}
}
