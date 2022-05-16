package fr.eni.ecole.Encheres.modeles.bll.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {

	private Integer id;
	private String name;
	private String description;
	private LocalDate auctionStartDate;
	private LocalDate auctionEndDate;
	private Integer initialPrice; 
	private Integer sellPrice;
	private Category category;
	private User user;
	private AuctionStatus auctionStatus;
	
	public Article() {
		this.id = 0;
	}

	public Article(String name, String description, LocalDate auctionStartDate,
			LocalDate auctionEndDate, Integer initialPrice, Integer sellPrice, Category category, User user,
			AuctionStatus auctionStatus) {
		super();
		this.name = name;
		this.description = description;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.initialPrice = initialPrice;
		this.sellPrice = sellPrice;
		this.category = category;
		this.user = user;
		this.auctionStatus = auctionStatus;
	}

	public Article(Integer id, String name, String description, LocalDate auctionStartDate, LocalDate auctionEndDate,
			Integer initialPrice, Integer sellPrice, Category category, User user, AuctionStatus auctionStatus) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.initialPrice = initialPrice;
		this.sellPrice = sellPrice;
		this.category = category;
		this.user = user;
		this.auctionStatus = auctionStatus;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAuctionStartDate() {
		return auctionStartDate;
	}

	public void setAuctionStartDate(LocalDate auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}

	public LocalDate getAuctionEndDate() {
		return auctionEndDate;
	}

	public void setAuctionEndDate(LocalDate auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	public Integer getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Integer initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Integer getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		return "Article [id=" + id + ", name=" + name + ", description=" + description + ", auctionStartDate="
				+ auctionStartDate + ", auctionEndDate=" + auctionEndDate + ", initialPrice=" + initialPrice
				+ ", sellPrice=" + sellPrice + ", category=" + category + ", user=" + user + ", auctionStatus="
				+ auctionStatus + "]";
	}
	
}
