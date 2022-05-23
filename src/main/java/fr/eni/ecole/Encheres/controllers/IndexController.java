package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.bll.managers.ArticleManager;
import fr.eni.ecole.Encheres.bll.managers.CategoryManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	private CategoryManager categoryManager = ManagerFactory.getCategoryManager();
	private ArticleManager articleManager = ManagerFactory.getArticleManager();
	private List<Category> categories;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		listerCategories(req);
		recupUser(req);
		this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("search");
		String categoryLabel = req.getParameter("categoryLabel").toUpperCase();
		listerCategories(req);
		recupUser(req);
		Category category = categoryManager.findByLabel(categoryLabel);
		List<Article> articles = new ArrayList<>();

		//traiter search pour qu'il ne contienne que des caracteres => regex party !
		if (search == "" && categoryLabel.equals("TOUTES")) {
			articles = articleManager.findAllInProgress();
		}else if (search == "" && !categoryLabel.equals("TOUTES")){
				articles = articleManager.findAllInProgressByCategory(category);
				System.out.println();
		}else {
			articles = articleManager.findAllInProgressByNameByCategory(search, category);
		}
		
		req.setAttribute("articles", articles);
		this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(req, resp);

	}

	private void recupUser(HttpServletRequest req) {
		User userConnected = (User) req.getSession().getAttribute("userConnected");
	}

	private void listerCategories(HttpServletRequest req) {
		categories = categoryManager.findAll();
		req.setAttribute("categories", categories);
	}

}
