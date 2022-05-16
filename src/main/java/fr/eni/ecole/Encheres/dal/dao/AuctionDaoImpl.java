package fr.eni.ecole.Encheres.dal.dao;

import fr.eni.ecole.Encheres.modeles.bll.bo.Auction;

public class AuctionDaoImpl extends AbstractDAO implements AuctionDao {

	private static AuctionDao instance = null; 
	
	private AuctionDaoImpl() {
		// pour singleton
	}
	
	public static AuctionDao getInstance() {
		if(instance == null) {
			instance = new AuctionDaoImpl();
		}
		return instance;
	}

	@Override
	public Auction save(Auction auction) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
