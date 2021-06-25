package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.IngredienteServiceImpl;

public class InserirIngrediente extends HttpServlet {
	
	private IngredienteServiceImpl ingredienteServiceImpl;
	
	@Override
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		
		try {
			ingredienteServiceImpl = new IngredienteServiceImpl();
			
			String nomeIngrediente = req.getParameter("nomeIngrediente");
			
			ingredienteServiceImpl.insert(nomeIngrediente);
			
			sc.getRequestDispatcher("/jsp/novo/confirmarInsercao.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/novo/novoingrediente.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
