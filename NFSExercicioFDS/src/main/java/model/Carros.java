package model;

public class Carros {
	private Integer id;
	private String model;
	private Integer ano;
	
		
	public Carros(String model, Integer ano) {
		
		this.model = model;
		this.ano = ano;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public String toString() {
		return this.id + " : " + this.model + this.ano;
	}

}
