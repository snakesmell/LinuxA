package com.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Interface4
 */
@WebServlet("/Interface4")
public class Interface4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Interface4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("var datay =[\"149\",\"148\",\"147\",\"146\",\"145\",\"144\",\"143\",\"142\",\"141\",\"140\",\"139\",\"138\",\"137\"];");
		sb.append("var datan1=[ 5,10, 5, 7, 4, 2, 1, 4, 1, 5,12,11, 3];");
		sb.append("var datan2=[10,12,10, 9, 7, 5, 9, 7,14,10,14,14, 7];");
		sb.append("var datan3=[15,15,11,21,10,13,11,17,19,16,19,15,10];");
		sb.append("var datan4=[18,17,13,22,14,15,13,19,23,26,23,16,14];");
		sb.append("var datan5=[19,19,27,26,16,23,20,20,26,27,24,27,21];");
		sb.append("var datan6=[32,20,28,32,26,26,29,24,30,33,27,32,24];");
		sb.append("var data  =[ 5, 8, 9, 3, 9, 7, 9,16,10, 1, 1, 9, 1];");
		/* 篮球区 */
		
		
		response.getWriter().append(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
