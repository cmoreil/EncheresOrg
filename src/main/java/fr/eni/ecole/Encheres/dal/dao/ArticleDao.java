package fr.eni.ecole.Encheres.dal.dao;

import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.SellStatus;

public interface ArticleDao {

	Article save(Article article);
	Article findById(Integer id);
	Article findByStatus(SellStatus sellStatus);
	Integer selectLastId();
	List<Article> findAll();
	void changeStatus(Article article);

}
