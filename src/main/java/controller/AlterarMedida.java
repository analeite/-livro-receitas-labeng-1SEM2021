package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Medida;
import main.java.model.MedidaServiceImpl;

public class AlterarMedida extends HttpServlet{
	
	
	MedidaServiceImpl medidaServiceImpl;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		ServletContext sc = req.getServletContext();
		
		try {
			medidaServiceImpl = new MedidaServiceImpl();
			
			Medida medida2 = new Medida();
			
			medida2.setIdMedidas(Integer.parseInt(req.getParameter("id").toString()));
			medida2.setNomeMedidas(req.getParameter("nome").toString());
			
			medidaServiceImpl.update(medida2);
			
			sc.getRequestDispatcher("/jsp/gerenciamento/confirmarAtualizacao.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/editar/editarmedida.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
