package main.java.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Receita;
import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;
import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaIngrediente;
import main.java.model.ReceitaCompletaIngredienteServiceImpl;
import main.java.model.ReceitaServiceImpl;
import main.java.model.ReceitaCompletaServiceImpl;

public class InserirReceita extends HttpServlet {

	private ReceitaCompletaServiceImpl receitaCompletaService;

	private ReceitaServiceImpl receitaServiceImpl;

	private IngredienteServiceImpl ingredienteService;
	
	private ReceitaCompletaIngredienteServiceImpl receitaCompletaIngredienteServiceImpl;
	
	@Override
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		
		try {
			receitaCompletaService = new ReceitaCompletaServiceImpl();
			receitaServiceImpl = new ReceitaServiceImpl();
			ingredienteService = new IngredienteServiceImpl();
			receitaCompletaIngredienteServiceImpl = new ReceitaCompletaIngredienteServiceImpl();
			
			String nomeReceita = req.getParameter("nomeReceita");
			String desc = req.getParameter("desc");
			String modoPreparo = req.getParameter("modoPreparo");
			
			String[] idIngredientes = req.getParameterValues("idIngrendientes");
			List<String> idIngredientesList = Arrays.asList(idIngredientes);

			ReceitaCompleta receitaCompleta = new ReceitaCompleta();

			Receita receita = receitaServiceImpl.insert(nomeReceita, desc, modoPreparo);

			receitaCompleta.setReceita(receitaServiceImpl.findById(receita.getIdReceitas()));

			List<Ingrediente> ingredientes = new LinkedList<>();
						
			Map<String, String[]> parameters = req.getParameterMap();

			List<String> quantidades = new LinkedList<>();

			for(String parameter : parameters.keySet()) {
			    if(parameter.toLowerCase().contains("quantidade")) {
							quantidades = Arrays.asList(parameters.get(parameter));
			    }
			}
			
			receitaCompletaService.insert(receitaCompleta);
			
			int cont = 0;
			
			for (String id : idIngredientesList) {
				
				String quantidade = quantidades.get(cont);
				
				Ingrediente ingrediente = ingredienteService.findById(Integer.parseInt(id));
				
				ReceitaCompletaIngrediente receitaCompletaIngrediente = new ReceitaCompletaIngrediente();
				
				receitaCompleta.setReceita(receitaServiceImpl.findById(receita.getIdReceitas()));
				
				receitaCompletaIngrediente.setReceitaCompleta(receitaCompleta);
				
				receitaCompletaIngrediente.setIdIngrediente(ingrediente);
				
				receitaCompletaIngrediente.setQuantidade(quantidade);
				
				System.out.println(receitaCompletaIngrediente.getQuantidade());
				
				receitaCompletaIngredienteServiceImpl.insert(receitaCompletaIngrediente);
				
				cont++;
		}
			
			sc.getRequestDispatcher("/jsp/novo/confirmarInsercao.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/novo/novareceita.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
