package fr.eni.ecole.Encheres.dal.dao;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;

public interface ArticleDao {

	Article save(Article article);
	Article findById(Integer id);
	
}