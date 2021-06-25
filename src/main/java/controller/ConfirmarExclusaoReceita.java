package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaServiceImpl;

public class ConfirmarExclusaoReceita extends HttpServlet{
	
	ReceitaCompletaServiceImpl receitaCompletaServiceImpl;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		try {
			receitaCompletaServiceImpl = new ReceitaCompletaServiceImpl();
			
			String id =req.getParameter("idReceitaCompleta");
			
			ReceitaCompleta receitaCompleta = receitaCompletaServiceImpl.findById(Integer.parseInt(id));

			String msg = receitaCompletaServiceImpl.delete(receitaCompleta);

			sc.getRequestDispatcher("/jsp/excluir/confirmarDelete.jsp").forward(req, resp);
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
