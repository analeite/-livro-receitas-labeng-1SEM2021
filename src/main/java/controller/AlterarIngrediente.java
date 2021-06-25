package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;

public class AlterarIngrediente extends HttpServlet{
	
	
	IngredienteServiceImpl ingredienteServiceImpl;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		ServletContext sc = req.getServletContext();
		
		try {
			ingredienteServiceImpl = new IngredienteServiceImpl();
			
			Ingrediente ingrediente2 = new Ingrediente();
			
			ingrediente2.setIdIngredientes(Integer.parseInt(req.getParameter("id").toString()));
			ingrediente2.setNomeIngredientes(req.getParameter("nome").toString());
			
			ingredienteServiceImpl.update(ingrediente2);
			
			sc.getRequestDispatcher("/jsp/gerenciamento/confirmarAtualizacao.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/editar/editaringrediente.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
