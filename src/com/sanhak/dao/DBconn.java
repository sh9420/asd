package com.sanhak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBconn {
	private Statement stmt = null;
	private Connection conn = null;	
	
	private String url="jdbc:mysql://localhost:3306/sanhak";
	private String id="root";
	private String pw="apmsetup";
	
	public Connection getDBConn() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,id,pw);
		
		if(conn!=null) System.out.println(conn.toString());
		
		return conn;
	}
	
}
