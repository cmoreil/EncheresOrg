package fr.eni.ecole.Encheres.dal.dao;

import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Category;

public interface CategoryDao {
	
	Category save(Category category);
	List<Category> findAll();
	Category findByLabel(String label);
}
