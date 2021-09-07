package com.simplilearn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.StudentOperationDao;
import com.simplilearn.entity.Students;

/**
 * Servlet implementation class CandidateServlet
 */

public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private StudentOperationDao sdo; 
    /**
     * @see HttpServlet#HttpServlet()
     */
      public void init(){
    	  sdo=new StudentOperationDao();
      }
    public CandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			listUser(request, response);
		} catch (SQLException e) {
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
	   private void listUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Students > listStudents = sdo.getAllStudents();
			        request.setAttribute("listStudent", listStudents);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("view-student-details.jsp");
			        dispatcher.forward(request, response);
			    }
}
