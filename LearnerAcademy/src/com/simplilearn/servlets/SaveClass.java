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

import com.simplilearn.dao.ClassesOperationDao;
import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Students;

/**
 * Servlet implementation class SaveClass
 */
@WebServlet("/saveClass")
public class SaveClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ClassesOperationDao cod;
	public void init(){
		cod=new ClassesOperationDao();
	}
    public SaveClass() {
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
			saveClassesDetail(request,response);
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

	private void saveClassesDetail(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		int savedcount=0;
		if(request.getParameter("className")!=null && !("").equals(request.getParameter("className"))){
		Classes classesdtl= new Classes(request.getParameter("className"));
		         savedcount=cod.SaveClassDetails(classesdtl);
		}if(savedcount>0){
		        String successMsg="New Class added to master";
		        request.setAttribute("successMsg", successMsg);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("add-class-master.jsp");
		        dispatcher.forward(request, response);
		        }
		else{
			 String failureMsg="Sorry, This Class already exist";
		        request.setAttribute("failureMsg", failureMsg);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("add-class-master.jsp");
		        dispatcher.forward(request, response);
		}
		    }
}
