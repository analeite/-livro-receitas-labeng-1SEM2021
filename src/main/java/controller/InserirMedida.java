package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.MedidaServiceImpl;

public class InserirMedida extends HttpServlet{
	
	private MedidaServiceImpl medidaServiceImpl;
	
	@Override
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		
		try {
			medidaServiceImpl = new MedidaServiceImpl();
			
			String nomeMedida = req.getParameter("nomeMedida");
			
			medidaServiceImpl.insert(nomeMedida);
			
			sc.getRequestDispatcher("/jsp/novo/confirmarInsercao.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/novo/novamedida.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
