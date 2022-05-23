package fr.eni.ecole.Encheres.bll.managers;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.Encheres.dal.dao.ArticleDao;
import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;
import fr.eni.ecole.Encheres.modeles.bll.bo.SellStatus;

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
		if(article.getAuctionStartDate().isAfter(now)) {
			article.setSellStatus(SellStatus.NOT_STARTED);
		}
		else if(article.getAuctionStartDate().equals(now)) {
			article.setSellStatus(SellStatus.IN_PROGRESS);
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

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public void changeStatus(Article article) {
		// pour que mon script auto change le statut de non débutee à in progress
		articleDao.changeStatus(article);
	}

	@Override
	public List<Article> findAllInProgress() {
		return articleDao.findAllInProgress();
	}

	@Override
	public List<Article> findAllInProgressByCategory(Category category) {
		return articleDao.findAllInProgressByCategory(category);
	}

	@Override
	public List<Article> findAllInProgressByNameByCategory(String search, Category category) {
		return articleDao.findAllInProgressByNameByCategory(search, category);
	}

}
