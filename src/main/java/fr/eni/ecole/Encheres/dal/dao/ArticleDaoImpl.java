package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.SellStatus;

public class ArticleDaoImpl extends AbstractDAO implements ArticleDao {

	private static ArticleDao instance = null;

	private ArticleDaoImpl() {
		// pour singleton
	}

	public static ArticleDao getInstance() {
		if (instance == null) {
			instance = new ArticleDaoImpl();
		}
		return instance;
	}

	@Override
	public Article save(Article article) {
		int generatedKey = 0;
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getName());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getAuctionStartDate()));
			pstmt.setDate(4, Date.valueOf(article.getAuctionEndDate()));
			pstmt.setInt(5, article.getInitialPrice());
			pstmt.setInt(6, article.getSellPrice());
			pstmt.setInt(7, article.getUser().getId());
			pstmt.setInt(8, article.getCategory().getId());
			pstmt.setString(9, article.getSellStatus().name());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
			    generatedKey = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		article.setId(generatedKey);
		return article;
	}
	
	public Integer selectLastId() {
		Integer id = 0;
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT MAX(no_article) FROM ARTICLES_VENDUS";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Article findById(Integer id) {
		Article article = new Article();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				article.setId(rs.getInt("no_article"));
				article.setName(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setAuctionStartDate(rs.getDate("date_debut_encheres").toLocalDate());
				article.setAuctionEndDate(rs.getDate("date_fin_encheres").toLocalDate());
				article.setInitialPrice(rs.getInt("prix_initial"));
				article.setSellPrice(rs.getInt("prix_vente"));
				
				article.getUser().setId(rs.getInt("no_utilisateur"));
				article.getCategory().setId(rs.getInt("no_categorie"));
				
				article.setSellStatus(SellStatus.valueOf(rs.getString("etat_vente")));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public List<Article> findAll() {
		List<Article> articles = new ArrayList<>();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("no_article"));
				article.setName(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setAuctionStartDate(rs.getDate("date_debut_encheres").toLocalDate());
				article.setAuctionEndDate(rs.getDate("date_fin_encheres").toLocalDate());
				article.setInitialPrice(rs.getInt("prix_initial"));
				article.setSellPrice(rs.getInt("prix_vente"));
				
				article.getUser().setId(rs.getInt("no_utilisateur"));
				article.getCategory().setId(rs.getInt("no_categorie"));
				
				article.setSellStatus(SellStatus.valueOf(rs.getString("etat_vente")));
				articles.add(article);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public void changeStatus(Article article) {
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "UPDATE ARTICLES_VENDUS SET etat_vente = ? WHERE no_article = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, String.valueOf(SellStatus.IN_PROGRESS));
			pstmt.setInt(2, article.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
