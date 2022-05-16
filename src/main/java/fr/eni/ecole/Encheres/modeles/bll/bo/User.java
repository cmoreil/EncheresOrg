package fr.eni.ecole.Encheres.modeles.bll.bo;

public class User {

	private final Integer CREDIT_OF_CREATION = 100;
	private Integer id;
	private String username;
	private String name;
	private String firstname;
	private String email;
	private String phone;
	private String street;
	private String postalCode;
	private String city;
	private String password;
	private String confirmPassword;
	private Integer credit;
	private Role role;

	public User() {
		this.id = 0;
	}

	public User(String username, String name, String firstname, String email, String phone, String street,
			String postalCode, String city, String password, String confirmPassword) {
		super();
		this.username = username;
		setName(name);
		this.firstname = firstname;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.postalCode = postalCode;
		setCity(city);
		this.password = password;
		this.confirmPassword = confirmPassword;
		setCredit(credit);
		setRole(role);
	}

	public User(Integer id, String username, String name, String firstname, String email, String phone, String street,
			String postalCode, String city, String password, Integer credit, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city.toUpperCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = CREDIT_OF_CREATION;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = Role.USER;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", firstname=" + firstname + ", email="
				+ email + ", phone=" + phone + ", street=" + street + ", postalCode=" + postalCode + ", city=" + city
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", credit=" + credit + ", role="
				+ role + "]";
	}

}
