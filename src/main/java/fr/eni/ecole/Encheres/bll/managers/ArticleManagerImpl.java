package fr.eni.ecole.Encheres.bll.managers;

import java.time.LocalDate;

import fr.eni.ecole.Encheres.dal.dao.ArticleDao;
import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.AuctionStatus;

public class ArticleManagerImpl implements ArticleManager {

	private static ArticleManager instance = null;
	private ArticleDao articleDao = DAOFactory.getArticleDao();
	
	private ArticleManagerImpl() {
	}

	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManagerImpl();
		}
		return instance;
	}

	@Override
	public Article save(Article article) {
		article.setSellPrice(article.getInitialPrice());	
		
		LocalDate now = LocalDate.now();
		if(article.getAuctionStartDate().isBefore(now)) {
			article.setAuctionStatus(AuctionStatus.PENDING);
		}
		else if(article.getAuctionStartDate().equals(now) || article.getAuctionStartDate().isAfter(now)) {
			article.setAuctionStatus(AuctionStatus.OPEN);
		}
		return articleDao.save(article);
	}

	@Override
	public Article findById(Integer id) {
		return articleDao.findById(id);
	}

	@Override
	public Integer selectLastId() {
		return articleDao.selectLastId();
	}
	
}
