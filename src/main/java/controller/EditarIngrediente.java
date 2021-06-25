package main.java.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;

public class EditarIngrediente extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		ServletContext sc = req.getServletContext();
		IngredienteServiceImpl ingredienteServiceImpl;
		ingredienteServiceImpl = new IngredienteServiceImpl();
		
		String idIngredientes = req.getParameter("idIngredientes");
		Ingrediente ingredientePesquisada = ingredienteServiceImpl.findById(Integer.parseInt(idIngredientes));
		
		req.setAttribute("id", ingredientePesquisada.getIdIngredientes());
    	req.setAttribute("nome", ingredientePesquisada.getNomeIngredientes());
		
		try {
			sc.getRequestDispatcher("/jsp/editar/editaringrediente.jsp").forward(req, resp);
		} catch (Exception e) {	}
		
	}

}
