package fr.eni.ecole.Encheres.bll.managers;

import java.util.Map;

public interface InscriptionManager {

	//pour g�n�rer des messages d'erreur pour chaque contr�le effectu�
	Map<String, String> check (String username, String name, String firstname, String email, String phone, String street, String postalCode, String city, String password, String confirmPassword);
}
