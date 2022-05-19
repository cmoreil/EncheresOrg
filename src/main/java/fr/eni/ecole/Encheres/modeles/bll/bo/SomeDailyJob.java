package fr.eni.ecole.Encheres.modeles.bll.bo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.bll.managers.ArticleManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;

public class SomeDailyJob implements Runnable {

	private ArticleManager articleManager = ManagerFactory.getArticleManager();
	private List<Article> articles = new ArrayList<>();;
	
	@Override
	public void run() {
		LocalDateTime dateHeureJour = LocalDateTime.now();
		LocalDate dateDuJour = LocalDate.now();
		Path path;
		
		//conditionner tout cela au fait que cela n'a pas déjà été fait
		//if le file avec date du jour existe : pas la peine
		
		//je crée la tâche 
		articles = articleManager.findAll();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getAuctionStartDate().isBefore(dateDuJour) || articles.get(i).getAuctionStartDate().equals(dateDuJour)){
				articleManager.changeStatus(articles.get(i));
			}
		}
		
		//je me créé un fichier qui me dit que c'est fait (à creuser pour y mettre le topo des chgts
		path = Paths.get("D:/fichier"+dateDuJour+".txt");
			try {
				String str = "Traitement fait le " + dateHeureJour;
				byte[] bs = str.getBytes();
				Path writtenFilePath = Files.write(path, bs);
				new String(Files.readAllBytes(writtenFilePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
