package fr.eni.ecole.Encheres.bll.managers;

import java.util.List;

import fr.eni.ecole.Encheres.dal.dao.CategoryDao;
import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;

public class CategoryManagerImpl implements CategoryManager {

	private static CategoryManager instance = null;
	private CategoryDao categoryDao = DAOFactory.getCategoryDao();

	private CategoryManagerImpl() {
	}

	public static CategoryManager getInstance() {
		if (instance == null) {
			instance = new CategoryManagerImpl();
		}
		return instance;
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category findByLabel(String label) {
		return categoryDao.findByLabel(label);

	}

}
