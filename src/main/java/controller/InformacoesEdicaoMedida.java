package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Medida;
import main.java.model.MedidaServiceImpl;

public class InformacoesEdicaoMedida extends HttpServlet{
	
	MedidaServiceImpl medidaServiceImpl;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = getServletContext();
		
		try {
			medidaServiceImpl = new MedidaServiceImpl();
			
			String id = req.getParameter("id");
			
			Medida medida = medidaServiceImpl.findById(Integer.parseInt(id));
			
			req.setAttribute("id", medida.getIdMedidas());
			req.setAttribute("nome", medida.getNomeMedidas());
			
			sc.getRequestDispatcher("/jsp/editar/editarmedida.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				sc.getRequestDispatcher("/jsp/gerenciamento/medida.jsp").forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
