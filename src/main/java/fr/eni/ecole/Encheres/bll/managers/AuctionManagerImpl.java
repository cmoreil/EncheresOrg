package fr.eni.ecole.Encheres.bll.managers;

import java.time.LocalDate;

import fr.eni.ecole.Encheres.dal.dao.AuctionDao;
import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.modeles.bll.bo.Auction;
import fr.eni.ecole.Encheres.modeles.bll.bo.AuctionStatus;

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
		LocalDate now = LocalDate.now();
		if(auction.getArticle().getAuctionStartDate().equals(now) || auction.getArticle().getAuctionStartDate().isBefore(now)) {
			auction.setAuctionStatus(AuctionStatus.OPENED);
		}
		auction.setAuctionDate(now);
		auctionDao.save(auction);
		return auction;
	}
	
}
