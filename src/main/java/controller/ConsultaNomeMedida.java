package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Medida;
import main.java.model.MedidaServiceImpl;

public class ConsultaNomeMedida extends HttpServlet{
	
	private MedidaServiceImpl medidaServiceImpl;
	private static List<Medida> listaMedidas;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		
		try {
			medidaServiceImpl = new MedidaServiceImpl();
			
			listaMedidas = new ArrayList<Medida>();
			
			String nomeMedidas = req.getParameter("nomeMedidas");
			
			if(nomeMedidas.isEmpty()) {
				
				listaMedidas = medidaServiceImpl.findAll();
				
			} else {
				
				listaMedidas = medidaServiceImpl.findByNome(nomeMedidas);

			}
			req.setAttribute("listaMedidas", listaMedidas);
			sc.getRequestDispatcher("/jsp/gerenciamento/medida.jsp").forward(req, resp);			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				req.getRequestDispatcher("/jsp/gerenciamento/medida.jsp").forward(req, resp);
				
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
