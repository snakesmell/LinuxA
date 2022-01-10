package com.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.demo.db.MySQLDemo;

/**
 * Servlet implementation class Interface3
 */
@WebServlet("/Interface3")
public class Interface3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Interface3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String limit = request.getParameter("limit");
		String sql = "SELECT a.*,0 AS b1 FROM (	SELECT id,r1,r2-r1 AS r2,r3-r2 AS r3,r4-r3 AS r4,r5-r4 AS r5,r6-r5 AS r6 FROM doubleball	ORDER BY id DESC	LIMIT "+limit+" )a ORDER BY a.id asc" ; 
		JSONArray arry =MySQLDemo.query(sql);
		response.getWriter().print(arry.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
