package com.trendnext.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trendnext.dao.UserDao;
import com.trendnext.dbutil.ConnectionFactory;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = getServletContext().getInitParameter("url");
		String user = getServletContext().getInitParameter("user");
		String dbpassword = getServletContext().getInitParameter("dbpassword");
		String driver = getServletContext().getInitParameter("name");

		Connection con = null;
		ConnectionFactory cf = new ConnectionFactory(url, user, dbpassword, driver);
		con = cf.getConnection();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		
		try {
			if(dao.validateLogin(con, username, password)) {
				response.getWriter().write("<b>Login success!</b>");
			} else {
				response.getWriter().write("<b>Login failed!</b>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
