package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;

public class InformacoesEdicaoIngrediente extends HttpServlet{
	
	IngredienteServiceImpl ingredienteServiceImpl;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = getServletContext();
		
		try {
			ingredienteServiceImpl = new IngredienteServiceImpl();
			
			String id = req.getParameter("id");
			
			Ingrediente ingrediente = ingredienteServiceImpl.findById(Integer.parseInt(id));
			
			req.setAttribute("id", ingrediente.getIdIngredientes());
			req.setAttribute("nome", ingrediente.getNomeIngredientes());
			
			sc.getRequestDispatcher("/jsp/editar/editaringrediente.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				sc.getRequestDispatcher("/jsp/gerenciamento/ingrediente.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
