package main.java.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Medida;
import main.java.model.MedidaServiceImpl;

public class ConfirmarExclusaoMedida extends HttpServlet{
	
	MedidaServiceImpl medidaServiceImpl;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		ServletContext sc = req.getServletContext();
		try {
			medidaServiceImpl = new MedidaServiceImpl();
			
			String id =req.getParameter("idMedidas");
			
			Medida medida = medidaServiceImpl.findById(Integer.parseInt(id));
			
			String msg = medidaServiceImpl.delete(medida);
			
			sc.getRequestDispatcher("/jsp/excluir/confirmarDelete.jsp").forward(req, resp);
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
