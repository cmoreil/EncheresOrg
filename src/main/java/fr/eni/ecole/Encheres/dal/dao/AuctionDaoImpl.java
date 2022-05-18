package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.eni.ecole.Encheres.modeles.bll.bo.Auction;

public class AuctionDaoImpl extends AbstractDAO implements AuctionDao {

	private static AuctionDao instance = null;

	private AuctionDaoImpl() {
		// pour singleton
	}

	public static AuctionDao getInstance() {
		if (instance == null) {
			instance = new AuctionDaoImpl();
		}
		return instance;
	}

	@Override
	public Auction save(Auction auction) {
		int generatedKey = 0;
		try (Connection con = PoolConnexion.getConnexion(database)) {
			final String QUERY = "INSERT INTO ENCHERES VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, Date.valueOf(auction.getAuctionDate()));
			pstmt.setInt(2, auction.getAmount());
			pstmt.setInt(3, auction.getArticle().getId());
			pstmt.setInt(4, auction.getUser().getId());
			pstmt.setString(5, auction.getAuctionStatus().name());
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		auction.setAuctionId(generatedKey);
		return auction;
	}
}
