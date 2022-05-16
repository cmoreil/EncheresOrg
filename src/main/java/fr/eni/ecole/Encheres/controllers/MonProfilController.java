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

@WebServlet(urlPatterns = "/connect/monprofil")
public class MonProfilController extends HttpServlet {

	private UserManager userManager = ManagerFactory.getUserManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/monProfil.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String name = req.getParameter("name");
		String firstname = req.getParameter("firstname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String street = req.getParameter("street");
		String postalCode = req.getParameter("postalCode");
		String city = req.getParameter("city");
		String password = req.getParameter("password");

		/*User utilisateurAModifier = new User(username, name, firstname, email, phone, street, postalCode, city,
				password);
		User userCo = (User) req.getSession().getAttribute("user");
		System.out.println(userCo);

		utilisateurAModifier.setId(userCo.getId());

		User utilisateurModifie = userManager.update(utilisateurAModifier);

		req.getSession().setAttribute("user", utilisateurModifie);

		this.getServletContext().getRequestDispatcher("/jsp/monProfil.jsp").forward(req, resp);

		System.out.println(userCo);*/
	}
	

}
