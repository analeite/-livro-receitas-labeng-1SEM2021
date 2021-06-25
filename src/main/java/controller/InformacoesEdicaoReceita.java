package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Receita;
import main.java.model.ReceitaServiceImpl;

public class InformacoesEdicaoReceita extends HttpServlet {
	
	ReceitaServiceImpl receitaServiceImpl;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = getServletContext();
		
		try {
			receitaServiceImpl = new ReceitaServiceImpl();
			
			String id = req.getParameter("id");
			
			Receita receita = receitaServiceImpl.findById(Integer.parseInt(id));
			
			req.setAttribute("id", receita.getIdReceitas());
			req.setAttribute("nome", receita.getNomeReceitas());
			req.setAttribute("descricao", receita.getDescricao());
			req.setAttribute("modo de preparo", receita.getModoPreparo());
			
			sc.getRequestDispatcher("/jsp/editar/editarreceita.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				sc.getRequestDispatcher("/jsp/gerenciamento/receita.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
