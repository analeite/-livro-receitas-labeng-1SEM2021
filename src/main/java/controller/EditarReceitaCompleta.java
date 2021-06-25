package main.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Ingrediente;
import main.java.model.IngredienteServiceImpl;
import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaServiceImpl;

public class EditarReceitaCompleta extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		ServletContext sc = req.getServletContext();
		ReceitaCompletaServiceImpl receitaCompletaServiceImpl;
		receitaCompletaServiceImpl = new ReceitaCompletaServiceImpl();
		
		String idReceitaCompleta = req.getParameter("id");
		ReceitaCompleta receitaPesquisada = receitaCompletaServiceImpl.findById(Integer.parseInt(idReceitaCompleta));
		
		req.setAttribute("id", receitaPesquisada.getIdReceitaCompleta());
    	req.setAttribute("nome", receitaPesquisada.getReceita().getNomeReceitas());
    	req.setAttribute("descricao", receitaPesquisada.getReceita().getDescricao());
    	req.setAttribute("preparo", receitaPesquisada.getReceita().getModoPreparo());
    	
		IngredienteServiceImpl ingredienteService = new IngredienteServiceImpl();
		
		List <Ingrediente> ingredientes = ingredienteService.findAll();

		List <Integer> idsIngredientes = receitaPesquisada.getReceitaCompletaIngrediente().stream().map(i -> i.getIdIngrediente().getIdIngredientes()).collect(Collectors.toList());
			
		List <Boolean> ingredientesDaReceita = new ArrayList<>();
		
		List <String> quantidadeIngredientes = receitaPesquisada.getReceitaCompletaIngrediente().stream().map(i -> i.getQuantidade()).collect(Collectors.toList());
		
		List <String> quantidadesDaReceita = new ArrayList<>();

		int count = 0;

		for (Ingrediente i : ingredientes) {
			Boolean exists = idsIngredientes.contains(i.getIdIngredientes());
			ingredientesDaReceita.add(exists);

			if (exists) {
					quantidadesDaReceita.add(quantidadeIngredientes.get(count));
					count++;
			} else {
					quantidadesDaReceita.add("0");
			}
		}
		
		
		req.setAttribute("ingredientesdareceita", ingredientesDaReceita);
		req.setAttribute("ingredientes", ingredientes);
		req.setAttribute("quantidadesDaReceita", quantidadesDaReceita);
		
		try {
			sc.getRequestDispatcher("/jsp/editar/editarreceita.jsp").forward(req, resp);
		} catch (Exception e) {	}
		
	}

}
