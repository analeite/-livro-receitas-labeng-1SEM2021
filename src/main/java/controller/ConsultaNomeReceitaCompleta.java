package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaServiceImpl;

public class ConsultaNomeReceitaCompleta extends HttpServlet{
	
	private ReceitaCompletaServiceImpl receitaCompletaServiceImpl;
	private static List<ReceitaCompleta> listaReceitas;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		
		try {
			receitaCompletaServiceImpl = new ReceitaCompletaServiceImpl();
			
			listaReceitas = new ArrayList<ReceitaCompleta>();
			
			String nomeReceitas = req.getParameter("nomeReceitas");
			
			if(nomeReceitas.isEmpty()) {
				
				listaReceitas = receitaCompletaServiceImpl.findAll();
				
			} else {
				
				listaReceitas = receitaCompletaServiceImpl.findByNome(nomeReceitas);

			}
			req.setAttribute("listaReceitas", listaReceitas);
			sc.getRequestDispatcher("/jsp/gerenciamento/receita.jsp").forward(req, resp);			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/gerenciamento/receita.jsp").forward(req, resp);
				
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
