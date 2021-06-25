package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaService;
import main.java.model.ReceitaCompletaServiceImpl;
import main.java.model.ReceitaServiceImpl;
import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;
import main.java.model.Medida;
import main.java.model.MedidaServiceImpl;
import main.java.model.Receita;


public class NovaReceitaCompleta extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		ServletContext sc = req.getServletContext();
		
		try{
			String idReceita = req.getParameter("idReceita");
			String idIngrediente = req.getParameter("idIngrediente");
			String idMedida = req.getParameter("idMedida");
			String quantidade = req.getParameter("quantidade");
			
			ReceitaCompleta receitaCompleta = new ReceitaCompleta();
			ReceitaServiceImpl receitaServiceImpl = new ReceitaServiceImpl();
			IngredienteServiceImpl ingredienteServiceImpl = new IngredienteServiceImpl();
			MedidaServiceImpl medidaServiceImpl = new MedidaServiceImpl();
	
			Receita receita = receitaServiceImpl.findById(Integer.parseInt(idReceita));
			
			Ingrediente ingrediente = ingredienteServiceImpl.findById(Integer.parseInt(idIngrediente));
			
			Medida medida = medidaServiceImpl.findById(Integer.parseInt(idMedida));
					
			receitaCompleta.setReceita(receita);
			//receitaCompleta.setIngrediente(ingrediente);			
			ReceitaCompletaServiceImpl receitaService = new ReceitaCompletaServiceImpl();
			
			receitaService.insert(receitaCompleta);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/novo/novareceitacompleta.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
	
		}
	}

}
