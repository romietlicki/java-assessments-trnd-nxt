package com.trendnext.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	
	PreparedStatement ps = null;
	
	public boolean validateLogin(Connection con, String userName, String password) {
		
		String sql= "select * from LoginTable where username = ? and password = ?";
		ResultSet rs = null;
		boolean autenticated = false;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				autenticated = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return autenticated;
	}
	
}
