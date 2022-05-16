package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.AuctionStatus;

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
			pstmt.setString(9, article.getAuctionStatus().name());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		article.setId(generatedKey);
		return article;
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
				//article.setCategory(rs.getInt("prix_vente"));
				//article.setUser(rs.getInt("prix_vente"));
				article.setAuctionStatus(AuctionStatus.valueOf(rs.getString("etat_vente")));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

}
