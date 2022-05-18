package fr.eni.ecole.Encheres.bll.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class InscriptionManagerImpl implements InscriptionManager {

	private static InscriptionManager instance = null;
	private Map<String, String> errors = new HashMap<>();

	private InscriptionManagerImpl() {
	}

	public static InscriptionManager getInstance() {
		if (instance == null) {
			instance = new InscriptionManagerImpl();
		}
		return instance;
	}

	@Override
	public Map<String, String> check(String username, String name, String firstname, String email, String phone,
			String street, String postalCode, String city, String password, String confirmPassword) {

		errors.clear();
		// variables pour regex username
		// pattern pour caracteres alpha, chiffres et _
		String regex = "^[a-zA-Z0-9_]*$";
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		//faire idem pour tel et code postal
		// a tester tel : ^(?:(?:\+|00)33[\s.-]{0,3}(?:\(0\)[\s.-]{0,3})?|0)[1-9](?:(?:[\s.-]?\d{2}){4}|\d{2}(?:[\s.-]?\d{3}){2})$

		//à compléter si temps avec des contrôles suppl ?
		if (username.length() > 0 && name.length() > 0 && firstname.length() > 0 && 
				 email.length() > 0 && phone.length() > 0 && street.length() > 0 && postalCode.length() > 0 &&
				 city.length() > 0 && password.length() > 0 && confirmPassword.length() > 0) {
			if (!pattern.matcher(username).matches()) {
				errors.put("username", "Le pseudo n'accepte que les caractères alphanumériques");
			}
			if (!password.equals(confirmPassword)) {
				errors.put("password", "Votre confirmation ne correspond pas au mot de passe");
			}
		} else {
			errors.put("emptyField", "Tous les champs sont requis");
		}
		return errors;
	}
}
