package fr.eni.ecole.Encheres.bll.managers;

import java.util.List;
import java.util.Map;

import fr.eni.ecole.Encheres.modeles.bll.bo.User;

public interface UserManager {

	User save(User user);
	User update(User utilisateurAModifier);
	String cryptedPsswd(String password);
	User findByEmailAndMdp(String mail, String password);
	List<User> findAll();
	//pour générer des messages d'erreur pour chaque contrôle effectué
	Map<String, String> checkAccountModif(String username, String name, String firstname, String email, String phone, String street, String postalCode, String city, String password);


}
