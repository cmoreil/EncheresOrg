package fr.eni.ecole.Encheres.dal.dao;

import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;

public interface ArticleDao {

	Article save(Article article);
	Article findById(Integer id);
	List<Article>  findAllInProgress();
	Integer selectLastId();
	List<Article> findAll();
	void changeStatus(Article article);
	List<Article> findAllInProgressByCategory(Category category);
	List<Article> findAllInProgressByNameByCategory(String search, Category category);

}
