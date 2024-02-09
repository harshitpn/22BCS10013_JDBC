package com.ayush.demoProject;
import java.sql.*;
public class ConnectionClass {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuims815","root","Har@1234");
        System.out.println("Connection Established");
		System.out.println(con.getClass().getName());
		return con;
		
	}
}