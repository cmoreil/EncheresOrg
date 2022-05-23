package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Article;
import fr.eni.ecole.Encheres.modeles.bll.bo.Category;
import fr.eni.ecole.Encheres.modeles.bll.bo.Role;
import fr.eni.ecole.Encheres.modeles.bll.bo.SellStatus;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;

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
			if (rs.next()) {
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
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur\r\n"
					+ "JOIN CATEGORIES ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie\r\n"
					+ "WHERE no_article = ?";
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

				User user = new User();
				user.setId(rs.getInt("no_utilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstname(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setRole(Role.valueOf(rs.getString("role")));

				Category category = new Category();
				category.setId(rs.getInt("no_categorie"));
				category.setLabel(rs.getString("libelle"));

				article.setUser(user);
				article.setCategory(category);

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
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS LEFT JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur\r\n"
					+ "JOIN CATEGORIES ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie";
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

				User user = new User();
				user.setId(rs.getInt("no_utilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstname(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setRole(Role.valueOf(rs.getString("role")));

				Category category = new Category();
				category.setId(rs.getInt("no_categorie"));
				category.setLabel(rs.getString("libelle"));

				article.setUser(user);
				article.setCategory(category);

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

	@Override
	public List<Article>  findAllInProgress() {
		List<Article> articles = new ArrayList<>();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur\r\n"
					+ "JOIN CATEGORIES ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie\r\n"
					+ "WHERE etat_vente = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, String.valueOf(SellStatus.IN_PROGRESS));
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

				User user = new User();
				user.setId(rs.getInt("no_utilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstname(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setRole(Role.valueOf(rs.getString("role")));

				Category category = new Category();
				category.setId(rs.getInt("no_categorie"));
				category.setLabel(rs.getString("libelle"));

				article.setUser(user);
				article.setCategory(category);

				article.setSellStatus(SellStatus.valueOf(rs.getString("etat_vente")));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> findAllInProgressByCategory(Category category) {
		List<Article> articles = new ArrayList<>();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur\r\n"
					+ "JOIN CATEGORIES ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie\r\n"
					+ "WHERE etat_vente = ? AND ARTICLES_VENDUS.no_categorie = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, String.valueOf(SellStatus.IN_PROGRESS));
			pstmt.setInt(2, category.getId());
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

				User user = new User();
				user.setId(rs.getInt("no_utilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstname(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setRole(Role.valueOf(rs.getString("role")));

				article.setUser(user);
				article.setCategory(category);

				article.setSellStatus(SellStatus.valueOf(rs.getString("etat_vente")));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> findAllInProgressByNameByCategory(String search, Category category) {
		List<Article> articles = new ArrayList<>();
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur\r\n"
					+ "JOIN CATEGORIES ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie\r\n"
					+ "WHERE etat_vente = ? AND UPPER(nom_article) LIKE UPPER(?) AND ARTICLES_VENDUS.no_categorie = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, String.valueOf(SellStatus.IN_PROGRESS));
			pstmt.setString(2, "%"+search+"%");
			pstmt.setInt(3, category.getId());
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

				User user = new User();
				user.setId(rs.getInt("no_utilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstname(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setRole(Role.valueOf(rs.getString("role")));

				article.setUser(user);
				article.setCategory(category);

				article.setSellStatus(SellStatus.valueOf(rs.getString("etat_vente")));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
}
