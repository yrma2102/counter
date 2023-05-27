package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        //String name = request.getParameter("name");
        //session.setAttribute("number", 1);
        if(session.getAttribute("number") == null) {
        	session.setAttribute("number", 1);
        }else {
        	session.setAttribute("number", (int)session.getAttribute("number")+1);
        }
        request.setAttribute("number", session.getAttribute("number"));
        System.out.println(session.getAttribute("number"));
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}

}
