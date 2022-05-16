package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Category;

public class CategoryDaoImpl extends AbstractDAO implements CategoryDao {

	private static CategoryDao instance = null;

	private CategoryDaoImpl() {
		// pour singleton
	}

	public static CategoryDao getInstance() {
		if (instance == null) {
			instance = new CategoryDaoImpl();
		}
		return instance;
	}

	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {

		List<Category> categories = new ArrayList<>();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM CATEGORIES";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("no_categorie"));
				category.setLabel(rs.getString("libelle"));
				categories.add(category);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category findByLabel(String label) {
		Category category = new Category();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM CATEGORIES WHERE libelle=?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, label);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				category.setId(rs.getInt("no_categorie"));
				category.setLabel(rs.getString("libelle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

}
