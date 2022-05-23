package fr.eni.ecole.Encheres.modeles.bll.bo;

import java.time.LocalDate;

public class Auction {

	private Integer auctionId;
	private LocalDate auctionDate;
	private Integer amount;
	private Article article;
	private User user;
	private AuctionStatus auctionStatus;
	
	public Auction() {
	}
	
	public Auction(LocalDate auctionDate, Integer amount, Article article, User user) {
		super();
		this.auctionDate = auctionDate;
		this.amount = amount;
		this.article = article;
		this.user = user;
	}
	
	public Auction(LocalDate auctionDate, Integer amount, Article article, User user, AuctionStatus auctionStatus) {
		super();
		this.auctionDate = auctionDate;
		this.amount = amount;
		this.article = article;
		this.user = user;
		this.auctionStatus = auctionStatus;
	}

	public Auction(Integer auctionId, LocalDate auctionDate, Integer amount, Article article, User user) {
		super();
		this.auctionId = auctionId;
		this.auctionDate = auctionDate;
		this.amount = amount;
		this.article = article;
		this.user = user;
	}
	
	public Auction(Integer auctionId, LocalDate auctionDate, Integer amount, Article article, User user,
			AuctionStatus auctionStatus) {
		super();
		this.auctionId = auctionId;
		this.auctionDate = auctionDate;
		this.amount = amount;
		this.article = article;
		this.user = user;
		this.auctionStatus = auctionStatus;
	}

	public Integer getAuctionId() {
		return auctionId;
	}
	
	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}
	
	public LocalDate getAuctionDate() {
		return auctionDate;
	}
	
	public void setAuctionDate(LocalDate auctionDate) {
		this.auctionDate = auctionDate;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Article getArticle() {
		return article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public AuctionStatus getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(AuctionStatus auctionStatus) {
		this.auctionStatus = auctionStatus;
	}

	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", auctionDate=" + auctionDate + ", amount=" + amount + ", article="
				+ article + ", user=" + user + ", auctionStatus=" + auctionStatus + "]";
	}

}
