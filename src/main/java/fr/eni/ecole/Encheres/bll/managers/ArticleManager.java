package fr.eni.ecole.Encheres.bll.managers;

import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;

public interface ArticleManager {

	Article save(Article article);
	Article findById(Integer id);
	Integer selectLastId();
	List<Article> findAll();
	void changeStatus(Article article);
	List<Article>findAllInProgress();
	List<Article> findAllInProgressByCategory(Category category);
	List<Article> findAllInProgressByNameByCategory(String search, Category category);
	
}
