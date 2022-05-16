package fr.eni.ecole.Encheres.modeles.bll.bo;

public class Category {
	private Integer id;
	private String label;
	

	public Category() {
	}

	public Category(String label) {
		super();
		setLabel(label);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label.toUpperCase();
	}


	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", label=" + label  + "]";
	}
}
