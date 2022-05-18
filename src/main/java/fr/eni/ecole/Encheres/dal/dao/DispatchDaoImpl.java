package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.ecole.Encheres.modeles.bll.bo.Dispatch;

public class DispatchDaoImpl extends AbstractDAO implements DispatchDao {

	private static DispatchDao instance = null;

	private DispatchDaoImpl() {
		// pour singleton
	}

	public static DispatchDao getInstance() {
		if (instance == null) {
			instance = new DispatchDaoImpl();
		}
		return instance;
	}

	@Override
	public Dispatch save(Dispatch dispatch) {
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "INSERT INTO RETRAITS VALUES (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, dispatch.getArticle().getId());
			pstmt.setString(2, dispatch.getStreet());
			pstmt.setString(3, dispatch.getPostalCode());
			pstmt.setString(4, dispatch.getCity());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dispatch;
	}
}
