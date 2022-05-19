package fr.eni.ecole.Encheres.bll.bo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.bll.managers.ArticleManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;

public class SomeDailyJob implements Runnable {

	private ArticleManager articleManager = ManagerFactory.getArticleManager();
	private List<Article> articles = new ArrayList<>();;
	
	@Override
	public void run() {
		LocalDateTime dateHeureJour = LocalDateTime.now();
		LocalDate dateDuJour = LocalDate.now();
		Path path;
		
		articles = articleManager.findAll();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getAuctionStartDate().isBefore(dateDuJour)){
				articleManager.changeStatus(articles.get(i));
			}
		}
		
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
