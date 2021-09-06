package com.simplilearn.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        String userId = request.getParameter("loginId");
        String password = request.getParameter("pass");
        if(userId!=null && userId.equalsIgnoreCase("admin")&& password!=null && password.equalsIgnoreCase("admin@123")){
        	 HttpSession session=request.getSession();  
             session.setAttribute("userid",  userId);
            // response.sendRedirect("dashboard");  
             request.setAttribute("userid", userId);
             RequestDispatcher dispatcher = request.getRequestDispatcher("welcome-admin.jsp");
             dispatcher.forward(request, response);
        }else{
        	String error="Invalid user, Please enter valid credentials";
        	request.setAttribute("errorMsg", error);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("errorMsg.jsp");
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
