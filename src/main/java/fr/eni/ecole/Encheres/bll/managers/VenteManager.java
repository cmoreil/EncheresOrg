package fr.eni.ecole.Encheres.bll.managers;

import java.time.LocalDate;
import java.util.Map;

public interface VenteManager {
	//pour générer des messages d'erreur pour chaque contrôle effectué
	Map<String, String> check(String name, String description, String categoryLabel, Integer initialPrice,
			LocalDate auctionStartDate, LocalDate auctionEndDate, String street, String postalCode, String city);
	
}
