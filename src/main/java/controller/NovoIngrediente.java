package main.java.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoIngrediente extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		ServletContext sc = req.getServletContext();
		try {
			sc.getRequestDispatcher("/jsp/novo/novoingrediente.jsp").forward(req, resp);
		} catch (Exception e) {	}
		
	}

}
