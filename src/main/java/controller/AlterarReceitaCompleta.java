package main.java.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Receita;
import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaServiceImpl;
import main.java.model.ReceitaCompletaIngrediente;
import main.java.model.ReceitaCompletaIngredienteServiceImpl;
import main.java.model.IngredienteServiceImpl;

public class AlterarReceitaCompleta extends HttpServlet{
	
	ReceitaCompletaServiceImpl receitaCompletaServiceImpl;

	ReceitaCompletaIngredienteServiceImpl receitaCompletaIngredienteServiceImpl;

	IngredienteServiceImpl ingredienteServiceImpl;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		ServletContext sc = req.getServletContext();
		
		try {
			receitaCompletaServiceImpl = new ReceitaCompletaServiceImpl();
			receitaCompletaIngredienteServiceImpl = new ReceitaCompletaIngredienteServiceImpl();
			ingredienteServiceImpl = new IngredienteServiceImpl();

			String idReceitaCompleta = req.getParameter("id");
			ReceitaCompleta receitaPesquisada = new ReceitaCompleta();

			receitaPesquisada.setReceita(new Receita());
			receitaPesquisada.setIdReceitaCompleta(Integer.parseInt(idReceitaCompleta));
			receitaPesquisada.getReceita().setNomeReceitas(req.getParameter("nome").toString());
			receitaPesquisada.getReceita().setDescricao(req.getParameter("descricao").toString());
			receitaPesquisada.getReceita().setModoPreparo(req.getParameter("preparo").toString());

			String[] quantidades = req.getParameterValues("quantidade");
			List<String> quantidadesList = Arrays.asList(quantidades);
			quantidadesList = new LinkedList<>(quantidadesList);

			String[] idIngredientes = req.getParameterValues("idIngredientes");
			List<Integer> idIngredientesList = Arrays.asList(idIngredientes).stream().map(i -> Integer.parseInt(i)).collect(
					Collectors.toList());
			idIngredientesList = new LinkedList<>(idIngredientesList);

			int cont = 0;

			ReceitaCompleta receita = receitaCompletaServiceImpl.findById(Integer.parseInt(idReceitaCompleta));

			List<ReceitaCompletaIngrediente> ingredientesReceita = receita.getReceitaCompletaIngrediente();

			LinkedList<Integer> idsSalvos = new LinkedList<>();

			for (ReceitaCompletaIngrediente r : ingredientesReceita) {
					if (idIngredientesList.contains(r.getIdIngrediente().getIdIngredientes())) {
							r.setQuantidade(quantidadesList.get(cont));
							receitaCompletaIngredienteServiceImpl.update(r);

							idsSalvos.add(r.getIdIngrediente().getIdIngredientes());

							cont++;
					}

			}

			cont = 0;

			for (Integer id : idIngredientesList) {
					if (!idsSalvos.contains(id)) {
							ReceitaCompletaIngrediente receitaCompletaIngrediente = new ReceitaCompletaIngrediente();
							receitaCompletaIngrediente.setReceitaCompleta(receitaPesquisada);
							receitaCompletaIngrediente.setQuantidade(quantidadesList.get(cont));
							receitaCompletaIngrediente.setIdIngrediente(ingredienteServiceImpl.findById(id));
							ingredientesReceita.add(receitaCompletaIngrediente);
							receitaCompletaIngredienteServiceImpl.insert(receitaCompletaIngrediente);
					}

					cont++;
			}

			receitaPesquisada.setReceitaCompletaIngrediente(ingredientesReceita);

			receitaCompletaServiceImpl.update(receitaPesquisada);
			
			sc.getRequestDispatcher("/jsp/gerenciamento/confirmarAtualizacao.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/editar/editarreceita.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
