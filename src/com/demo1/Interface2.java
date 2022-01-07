package com.demo1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.db.MySQLDemo;

/**
 * Servlet implementation class Interface2
 */
@WebServlet("/Interface2")
public class Interface2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Interface2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no=request.getParameter("no");
		String r1=request.getParameter("r1");
		String r2=request.getParameter("r2");
		String r3=request.getParameter("r3");
		String r4=request.getParameter("r4");
		String r5=request.getParameter("r5");
		String r6=request.getParameter("r6");
		String b1=request.getParameter("b1");
		boolean flag=MySQLDemo.insert(no, r1, r2, r3, r4, r5, r6, b1);
		
//		RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080/ThePage/");
//		rd.forward(request,response);
		response.sendRedirect("http://123.56.193.124:8080/ThePage/");
//		response.getWriter().write(flag+"");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
