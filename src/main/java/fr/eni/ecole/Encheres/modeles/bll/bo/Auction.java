package fr.eni.ecole.Encheres.modeles.bll.bo;

import java.time.LocalDateTime;

public class Auction {

	private Integer auctionId;
	private LocalDateTime auctionDate;
	private Double bidAmount;
	private Article article;
	private User user;

	public Auction() {
	}

	public Auction(Integer auctionId, LocalDateTime auctionDate, Double bidAmount, Article article, User user) {
		super();
		this.auctionId = auctionId;
		this.auctionDate = auctionDate;
		this.bidAmount = bidAmount;
		this.article = article;
		this.user = user;
	}

	public Integer getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}

	public LocalDateTime getAuctionDate() {
		return auctionDate;
	}

	public void setAuctionDate(LocalDateTime auctionDate) {
		this.auctionDate = auctionDate;
	}

	public Double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
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

	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", auctionDate=" + auctionDate + ", bidAmount=" + bidAmount
				+ ", article=" + article + ", user=" + user + "]";
	}

}
