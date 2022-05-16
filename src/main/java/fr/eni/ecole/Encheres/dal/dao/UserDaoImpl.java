package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.Role;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;

public class UserDaoImpl extends AbstractDAO implements UserDao {

	private UserDaoImpl() {
		// pour singleton
	}

	private static UserDao instance = null;

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public User save(User user) {
		int generatedKey = 0;
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "INSERT INTO Utilisateurs VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getFirstname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getStreet());
			pstmt.setString(7, user.getPostalCode());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getPassword());
			pstmt.setInt(10, user.getCredit());
			pstmt.setString(11, user.getRole().name());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setId(generatedKey);
		return user;
	}

	@Override
	public User update(User utilisateurAModifier) {
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, utilisateurAModifier.getUsername());
			pstmt.setString(2, utilisateurAModifier.getName());
			pstmt.setString(3, utilisateurAModifier.getFirstname());
			pstmt.setString(4, utilisateurAModifier.getEmail());
			pstmt.setString(5, utilisateurAModifier.getPhone());
			pstmt.setString(6, utilisateurAModifier.getStreet());
			pstmt.setString(7, utilisateurAModifier.getPostalCode());
			pstmt.setString(8, utilisateurAModifier.getCity());
			pstmt.setString(9, utilisateurAModifier.getPassword());
			pstmt.setInt(10, utilisateurAModifier.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return utilisateurAModifier;
	}

	@Override
	public void delete(User user) {
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "DELETE FROM Utilisateurs WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, user.getId());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findByEmailAndMdp(String mail, String password) {
		User user = new User();

		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "SELECT * FROM UTILISATEURS WHERE email = ? and mot_de_passe = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, mail);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				user.setId(rs.getInt("no_utilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstname(rs.getString("prenom"));
				user.setEmail(mail);
				user.setPhone(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(password);
				user.setCredit(rs.getInt("credit"));
				user.setRole(Role.valueOf(rs.getString("user_role")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		try (Connection con = PoolConnexion.getConnexion(database)) {
		final String QUERY = "SELECT * FROM Utilisateurs";
		PreparedStatement pstmt = con.prepareStatement(QUERY);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("no_utilisateur"));
		user.setUsername(rs.getString("no_utilisateur"));
		user.setName(rs.getString("no_utilisateur"));
		user.setFirstname(rs.getString("no_utilisateur"));
		user.setEmail(rs.getString("no_utilisateur"));
		user.setPhone(rs.getString("no_utilisateur"));
		user.setStreet(rs.getString("no_utilisateur"));
		user.setPostalCode(rs.getString("no_utilisateur"));
		user.setCity(rs.getString("no_utilisateur"));
		user.setPassword(rs.getString("no_utilisateur"));
		user.setCredit(rs.getInt("no_utilisateur"));
		user.setRole(Role.valueOf(rs.getString("user_role")));
		users.add(user);
		}

		} catch (Exception e) {
		e.printStackTrace();
		}
		return users;
		}

}
