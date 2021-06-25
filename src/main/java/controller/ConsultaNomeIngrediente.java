package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;

public class ConsultaNomeIngrediente extends HttpServlet{
	
	private IngredienteServiceImpl ingredienteServiceImpl;
	private static List<Ingrediente> listaIngredientes;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		
		try {
			ingredienteServiceImpl = new IngredienteServiceImpl();
			
			listaIngredientes = new ArrayList<Ingrediente>();
			
			String nomeIngredientes = req.getParameter("nomeIngredientes");
			
			if(nomeIngredientes.isEmpty()) {
				
				listaIngredientes = ingredienteServiceImpl.findAll();
				
			} else {
				
				listaIngredientes = ingredienteServiceImpl.findByNome(nomeIngredientes);

			}
			req.setAttribute("listaIngredientes", listaIngredientes);
			sc.getRequestDispatcher("/jsp/gerenciamento/ingrediente.jsp").forward(req, resp);			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/gerenciamento/ingrediente.jsp").forward(req, resp);
				
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
