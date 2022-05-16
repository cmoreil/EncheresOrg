package fr.eni.ecole.Encheres.modeles.bll.bo;

public class Dispatch {

	private Article article;
	private String street;
	private String postalCode;
	private String city;
	
	public Dispatch() {
		// TODO Auto-generated constructor stub
	}

	public Dispatch(Article article, String street, String postalCode, String city) {
		super();
		this.article = article;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Dispatch [article=" + article + ", street=" + street + ", city=" + city + ", postalCode=" + postalCode
				+ "]";
	}

}
