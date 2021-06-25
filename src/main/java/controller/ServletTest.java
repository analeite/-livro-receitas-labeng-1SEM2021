package main.java.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

@WebServlet({"*.action","/"})
public class ServletTest extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,
			HttpServletResponse res){

		String path = req.getServletPath();
		ServletContext sc = req.getServletContext();
		System.out.println(path); 
		switch (path) {
		case "/index.action":
			try{
				sc.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
			} catch (Exception e){}
			break;
		case "/sucesso.action":
			try{
				req.setCharacterEncoding("UTF-8");
				String nome = req.getParameter("nome_receita");
				nome = nome.toUpperCase();

				String ingred = req.getParameter("ingredientes");
				ingred = ingred.toUpperCase();
				
				String modo = req.getParameter("modo_preparo");
				modo = modo.toUpperCase();
				
				res.setContentType("text/html");
				res.setCharacterEncoding("UTF-8");
				
				req.setAttribute("nomeReceita", nome);
				req.setAttribute("ingredi", ingred);
				req.setAttribute("modoPreparo", modo);

				
				sc.getRequestDispatcher("/jsp/resposta.jsp").forward(req, res);
			}catch (Exception e){}
			break;
		default:
			try{
				sc.getRequestDispatcher("/jsp/naoencontrado.jsp").forward(req, res);
			}catch (Exception e){}		
		}
	}
}
