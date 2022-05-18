package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;
import java.util.List;

import fr.eni.ecole.Encheres.bll.managers.CategoryManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.bll.managers.UserManager;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connexion")
public class ConnexionController extends HttpServlet {

	private UserManager userManager = ManagerFactory.getUserManager();
	private CategoryManager categoryManager = ManagerFactory.getCategoryManager();
	private List<Category> categories;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		listerCategories(request);
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
	
	private void listerCategories(HttpServletRequest request) {
		categories = categoryManager.findAll();
		request.setAttribute("categories", categories);
	}

}
