package main.java.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Medida;
import main.java.model.MedidaServiceImpl;

public class EditarMedida extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		ServletContext sc = req.getServletContext();
		MedidaServiceImpl medidaServiceImpl;
		medidaServiceImpl = new MedidaServiceImpl();
		
		String idMedidas = req.getParameter("idMedidas");
		Medida medidaPesquisada = medidaServiceImpl.findById(Integer.parseInt(idMedidas));
		
		req.setAttribute("id", medidaPesquisada.getIdMedidas());
    	req.setAttribute("nome", medidaPesquisada.getNomeMedidas());
		
		try {
			sc.getRequestDispatcher("/jsp/editar/editarmedida.jsp").forward(req, resp);
		} catch (Exception e) {	}
		
	}

}
