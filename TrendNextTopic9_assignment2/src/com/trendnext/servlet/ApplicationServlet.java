package com.trendnext.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		sdf1.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
		sdf2.setTimeZone(TimeZone.getTimeZone("Japan"));
		sdf3.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong"));
		sdf4.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		sdf5.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
		
		response.getWriter().write("<b>Hello World in English:"+sdf.format(date)+" </b><br>");
		response.getWriter().write("<b>Hello World in Spanish:"+sdf1.format(date)+" </b><br>");
		response.getWriter().write("<b>Hello World in Japanese:"+sdf2.format(date)+" </b><br>");
		response.getWriter().write("<b>Hello World in Chinese:"+sdf3.format(date)+" </b><br>");
		response.getWriter().write("<b>Hello World in Korean:"+sdf4.format(date)+" </b><br>");
		response.getWriter().write("<b>Hello World in Russian:"+sdf5.format(date)+" </b><br>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
