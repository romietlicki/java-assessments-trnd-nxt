package com.trendnext.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	Connection con = null;
	String url = null;
	String user = null;
	String password = null;
	String driver = null;

	public ConnectionFactory(String url, String user, String password, String driver) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;
	}
	
	public Connection getConnection() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Success");
		}catch(Exception e) {
			System.out.println("error while connection to the database "+e.getMessage());
		}
		
		return con;
	}
	
	public void closeConnection() throws SQLException {
		if(con != null) {
			con.close();
		}
	}

}
