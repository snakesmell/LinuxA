package com.demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class interfaceFile
 */
@WebServlet("/interfaceFile")
public class interfaceFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public interfaceFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("path");
		String path="/home/files/"+filename;
		System.out.println(path);
		 try {
//			    String strPdfPath = new String("D://200701010001.PDF");
			    //判断该路径下的文件是否存在
			    File file = new File(path);
			    if (file.exists()) {
				     DataOutputStream temps = new DataOutputStream(response.getOutputStream());
				     DataInputStream in = new DataInputStream(new FileInputStream(path));
				     byte[] b = new byte[2048];
				     while ((in.read(b)) != -1) {
					      temps.write(b);
					      temps.flush();
				     }
				     in.close();
				     temps.close();
			    } else {
			    	System.out.println("文件不存在!");
			    }
			 } catch (Exception e) {
			    e.printStackTrace();
		     }
		
//		FileOutputStream fos = new FileOutputStream(path, true);
//        fos.write(string.getBytes());
		
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
