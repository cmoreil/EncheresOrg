package fr.eni.ecole.Encheres.bll.managers;

import fr.eni.ecole.Encheres.dal.dao.AuctionDao;
import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Auction;

public class AuctionManagerImpl implements AuctionManager{
	
	private static AuctionManager instance = null;
	private AuctionDao auctionDao = DAOFactory.getAuctionDao();
	
	private AuctionManagerImpl() {
	}

	public static AuctionManager getInstance() {
		if (instance == null) {
			instance = new AuctionManagerImpl();
		}
		return instance;
	}

	@Override
	public Auction save(Auction auction) {
		// vérif si set à faire
		auctionDao.save(auction);
		return auction;
	}
	
}
