package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connect/deconnexion")
public class DeconnexionController extends HttpServlet{

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//suppression de la session
		request.getSession().invalidate();
		
		this.getServletContext()
			.getRequestDispatcher("/jsp/index.jsp")
			.forward(request, response);
	}
}
