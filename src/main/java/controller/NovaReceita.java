package main.java.controller;

import  main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;
import  main.java.model.Medida;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaReceita extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		ServletContext sc = req.getServletContext();
		try {
			
			List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
			
			IngredienteServiceImpl ingredienteService = new IngredienteServiceImpl();
			
			ingredientes = ingredienteService.findAll();

			req.setAttribute("ingredientes", ingredientes);
			
			sc.getRequestDispatcher("/jsp/novo/novareceita.jsp").forward(req, resp);
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