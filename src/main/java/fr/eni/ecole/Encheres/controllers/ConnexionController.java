package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;

import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.bll.managers.UserManager;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connexion")
public class ConnexionController extends HttpServlet {

	UserManager userManager = ManagerFactory.getUserManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		User userConnected = userManager.findByEmailAndMdp(mail, password);
		if (userConnected.getId() > 0) {
			request.getSession().setAttribute("userConnected", userConnected);
			this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		} else {
			request.setAttribute("erreur", "Email ou mot de passe incorrect");
			this.getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
		}
	}

}
