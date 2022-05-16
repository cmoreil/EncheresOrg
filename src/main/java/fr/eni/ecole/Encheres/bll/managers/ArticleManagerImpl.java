package fr.eni.ecole.Encheres.bll.managers;

import fr.eni.ecole.Encheres.dal.dao.ArticleDao;
import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Article;

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
		articleDao.save(article);
		return article;
	}

	@Override
	public Article findById(Integer id) {
		return articleDao.findById(id);
	}
	
}
