package fr.eni.ecole.Encheres.bll.managers;

import java.util.Map;

public interface InscriptionManager {

	//pour générer des messages d'erreur pour chaque contrôle effectué
	Map<String, String> check (String username, String name, String firstname, String email, String phone, String street, String postalCode, String city, String password, String confirmPassword);
}
