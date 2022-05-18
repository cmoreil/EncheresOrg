package fr.eni.ecole.Encheres.bll.managers;

import java.time.LocalDate;
import java.util.Map;

public interface VenteManager {
	//pour g�n�rer des messages d'erreur pour chaque contr�le effectu�
	Map<String, String> check(String name, String description, String categoryLabel, Integer initialPrice,
			LocalDate auctionStartDate, LocalDate auctionEndDate, String street, String postalCode, String city);
	
}
