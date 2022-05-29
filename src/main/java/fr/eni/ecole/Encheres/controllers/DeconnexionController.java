package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;
import java.util.List;

import fr.eni.ecole.Encheres.bll.managers.CategoryManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connect/deconnexion")
public class DeconnexionController extends HttpServlet {

	private CategoryManager categoryManager = ManagerFactory.getCategoryManager();
	private List<Category> categories;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// suppression de la session
		req.getSession().invalidate();

		listerCategories(req);
		resp.sendRedirect(req.getContextPath() + "/index");
	}

	private void listerCategories(HttpServletRequest req) {
		categories = categoryManager.findAll();
		req.setAttribute("categories", categories);
	}
}
