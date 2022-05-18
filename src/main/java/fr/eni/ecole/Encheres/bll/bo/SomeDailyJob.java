package fr.eni.ecole.Encheres.bll.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.bll.managers.ArticleManager;
import fr.eni.ecole.Encheres.bll.managers.ManagerFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.SellStatus;

public class SomeDailyJob implements Runnable {

	private ArticleManager articleManager = ManagerFactory.getArticleManager();
	private List<Article> articles = new ArrayList<>();;
	
	@Override
	public void run() {
		System.out.println("je passe dans runnable");
		LocalDate dateDuJour = LocalDate.now();
		articles = articleManager.findAll();
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getAuctionStartDate().isBefore(dateDuJour)){
				articleManager.changeStatus(articles.get(i));
			}
		}
	}
}
