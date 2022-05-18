package fr.eni.ecole.Encheres.bll.managers;

import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.User;

public interface UserManager {

	User save(User user);
	User update(User utilisateurAModifier);
	String cryptedPsswd(String password);
	User findByEmailAndMdp(String mail, String password);
	List<User> findAll();

}
