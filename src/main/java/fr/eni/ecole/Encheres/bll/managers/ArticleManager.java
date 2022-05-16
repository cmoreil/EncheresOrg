package fr.eni.ecole.Encheres.bll.managers;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;

public interface ArticleManager {

	Article save(Article article);
	Article findById(Integer id);
	Integer selectLastId();
}
