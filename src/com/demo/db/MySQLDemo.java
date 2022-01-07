package com.demo.db;
 
import java.sql.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class MySQLDemo {
 
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://123.56.193.124:3306/scity?useSSL=false";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "Aduan1234";
 
    public static JSONArray query() {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM doubleball order by id asc";
            ResultSet rs = stmt.executeQuery(sql);
            
            
            JSONArray sum = new JSONArray();
            
            // 展开结果集数据库
            while(rs.next()){
            	JSONArray arry = new JSONArray();
                // 通过字段检索
                String name  = rs.getString("id");
                String name1 = rs.getString("r1");
                String name2 = rs.getString("r2");
                String name3 = rs.getString("r3");
                String name4 = rs.getString("r4");
                String name5 = rs.getString("r5");
                String name6 = rs.getString("r6");
                String name7 = rs.getString("b1");
                arry.add(name);
                arry.add(name1);
                arry.add(name2);
                arry.add(name3);
                arry.add(name4);
                arry.add(name5);
                arry.add(name6);
                arry.add(name7);
                sum.add(arry);
            }
            System.out.println(sum.toJSONString());
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return sum;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    
    public static boolean insert(String no,String r1,String r2,String r3,String r4,String r5,String r6,String b1) {
	    Connection conn = null;
	    Statement stmt = null;
	    try{
	        // 注册 JDBC 驱动
	        Class.forName(JDBC_DRIVER);
	    
	        // 打开链接
	        System.out.println("连接数据库...");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    
	        // 执行查询
	        System.out.println(" 实例化Statement对象...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "insert into doubleball VALUES('"+no+"','"+r1+"','"+r2+"','"+r3+"','"+r4+"','"+r5+"','"+r6+"','"+b1+"');";
	        boolean rs = stmt.execute(sql);
	        
	        // 完成后关闭
	        stmt.close();
	        conn.close();
	        return rs;
    }catch(Exception e){
        e.printStackTrace();
        return false;
    }finally{
        // 关闭资源
        try{
            if(stmt!=null) stmt.close();
        }catch(SQLException se2){
        }// 什么都不做
        try{
            if(conn!=null) conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
}