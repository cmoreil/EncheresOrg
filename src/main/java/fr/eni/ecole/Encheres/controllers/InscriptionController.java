package fr.eni.ecole.Encheres.controllers;

import java.io.IOException;
import java.util.Map;

import fr.eni.ecole.Encheres.bll.managers.InscriptionManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.bll.managers.UserManager;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class InscriptionController extends HttpServlet {

	private InscriptionManager inscriptionManager = ManagerFactory.getInscriptionManager();
	private UserManager userManager = ManagerFactory.getUserManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/inscription.jsp").forward(req, resp);
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
		String confirmPassword = req.getParameter("confirmPassword");

		//on créé une méthode pour générer des messages d'erreurs en fonction des pb possibles sur champs
		Map<String, String> errors = inscriptionManager.check(username, name, firstname,email, phone, street, 
				postalCode, city, password, confirmPassword );
		User userCo = userManager.findByEmailAndMdp(email,password);
		
		//si pas d'erreur alors on atteint la page accueil en tant que co sinon cf. messages erreurs
		if (errors.isEmpty()) {
			if(!email.equals(userCo.getEmail()) && !username.equals(userCo.getUsername())) {
				User user = new User(username, name, firstname,email, phone, street, 
						postalCode, city, password, confirmPassword);
				User userConnected = userManager.save(user);
				req.getSession().setAttribute("userConnected", userConnected);
				//revoir l'envoi vers index car la page d'accueil augmente une fois la co établie
				resp.sendRedirect(req.getContextPath()+"/index");
			}else {
				req.setAttribute("unicité", "Ce pseudo et/ou cet email sont déjà pris");
				this.getServletContext().getRequestDispatcher("/jsp/inscription.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("errors", errors);
			this.getServletContext().getRequestDispatcher("/jsp/inscription.jsp").forward(req, resp);
		}
	}
}
