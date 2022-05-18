package fr.eni.ecole.Encheres.bll.managers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import fr.eni.ecole.Encheres.modeles.bll.bo.AuctionStatus;

public class VenteManagerImpl implements VenteManager{

	private static VenteManager instance = null;
	private Map<String, String> SellsErrors = new HashMap<>();

	private VenteManagerImpl() {
	}

	public static VenteManager getInstance() {
		if (instance == null) {
			instance = new VenteManagerImpl();
		}
		return instance;
	}
	
	@Override
	public Map<String, String> check(String name, String description, String categoryLabel, Integer initialPrice,
			LocalDate auctionStartDate, LocalDate auctionEndDate, String street, String postalCode, String city) {

		SellsErrors.clear();
		
		String regex = "^[a-zA-Z|\s.?!,;]*$";
		String regex2 = "^[a-zA-Z0-9_-|'|\s|.?!,;]*$";
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
		LocalDate now = LocalDate.now();
		
		//à compléter si temps avec des contrôles mieux étudiés
		if (name.length() > 0 && description.length() > 0 && categoryLabel.length() > 0 && 
				initialPrice > 0 && street.length() > 0 && postalCode.length() > 0 &&
				 city.length() > 0) {
			if (!pattern.matcher(name).matches()) {
				SellsErrors.put("name", "Le libelle de votre article n'accepte que les caractères alphabétiques");
			}
			if (!pattern2.matcher(description).matches()) {
				SellsErrors.put("description", "La description n'accepte que les caractères alphanumériques");
			}
			if (description.length() > 300) {
				SellsErrors.put("desciption2", "La description ne doit pas excéder 300 caractères");
			}
			if(auctionStartDate.isBefore(now)) {
				SellsErrors.put("date", "La date de début doit obligatoirement être égale ou supérieure à la date du jour");
			}
			if(auctionEndDate.isBefore(auctionStartDate)) {
				SellsErrors.put("date2", "La date de fin doit obligatoirement être supérieure à la date de début");
			}
			
		} else {
			SellsErrors.put("emptyField", "Tous les champs sont requis");
		}
		
		return SellsErrors;
	}

}
