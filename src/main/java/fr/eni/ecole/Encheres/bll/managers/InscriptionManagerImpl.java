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

		//� compl�ter si temps avec des contr�les suppl ?
		if (username.length() > 0 && name.length() > 0 && firstname.length() > 0 && 
				 email.length() > 0 && phone.length() > 0 && street.length() > 0 && postalCode.length() > 0 &&
				 city.length() > 0 && password.length() > 0 && confirmPassword.length() > 0) {
			if (!pattern.matcher(username).matches()) {
				errors.put("username", "Le pseudo n'accepte que les caract�res alphanum�riques");
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
