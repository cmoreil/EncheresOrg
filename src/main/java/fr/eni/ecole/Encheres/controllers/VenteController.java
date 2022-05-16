package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import fr.eni.ecole.Encheres.bll.managers.ArticleManager;
import fr.eni.ecole.Encheres.bll.managers.CategoryManager;
import fr.eni.ecole.Encheres.bll.managers.DispatchManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.AuctionStatus;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;
import fr.eni.ecole.Encheres.modeles.bll.bo.Dispatch;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connect/vente")
public class VenteController extends HttpServlet {

	CategoryManager categoryManager = ManagerFactory.getCategoryManager();
	ArticleManager articleManager = ManagerFactory.getArticleManager();
	DispatchManager dispatchManager = ManagerFactory.getDispatchManager();
	VenteManager venteManager = ManagerFactory.getVenteManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/vente.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String categoryLabel = req.getParameter("categoryLabel").toUpperCase();
		Integer initialPrice = Integer.valueOf(req.getParameter("initialPrice"));
		LocalDate auctionStartDate = LocalDate.parse(req.getParameter("auctionStartDate"));
		LocalDate auctionEndDate = LocalDate.parse(req.getParameter("auctionEndDate"));
		String street = req.getParameter("street");
		String postalCode = req.getParameter("postalCode");
		String city = req.getParameter("city");
		Integer sellPrice =Integer.valueOf(req.getParameter("initialPrice"));
		AuctionStatus etatPourCetteVente = AuctionStatus.PENDING;
		
		Map<String, String> SellsErrors = venteManager.check(name,description, categoryLabel, initialPrice,
				auctionStartDate,auctionEndDate, street, postalCode,city, etatPourCetteVente);
		
		if (SellsErrors.isEmpty()) {
		
		//récupération et construct des objets à envoyer pour créer un article
		Category categoryAVendre = categoryManager.findByLabel(categoryLabel);
		
		//récupération et construct des objets à envoyer pour créer un article
		User utilisateurConnecte = 
				(User) req.getSession().getAttribute("userConnected");
	
		//récupération et construct des objets à envoyer pour créer un article
		Article articleAVendre = new Article(name, description, auctionStartDate, auctionEndDate, initialPrice, sellPrice, categoryAVendre, utilisateurConnecte, etatPourCetteVente);
		articleAVendre.setCategory(categoryAVendre);
		articleAVendre.setUser(utilisateurConnecte);
		articleManager.save(articleAVendre);
		req.setAttribute("articleAVendre", articleAVendre);
		
		//récupération et construct des objets à envoyer pour créer une adresse de retrait
		Dispatch dispatchCree = new Dispatch(articleAVendre, street, postalCode, city);
		System.out.println(dispatchCree);
		dispatchManager.save(dispatchCree);
		req.setAttribute("dispatchCree", dispatchCree);
		
		this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		} else {
			req.setAttribute("SellsErrors", SellsErrors);
			this.getServletContext().getRequestDispatcher("/jsp/vente.jsp").forward(req, resp);
		}
		
	}
}
