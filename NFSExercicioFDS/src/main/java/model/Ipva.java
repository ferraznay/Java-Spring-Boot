package model;

public class Ipva {

	private Integer id;
	private Integer ano;
	
	public Ipva( Integer ano) {

		this.ano = ano;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	public String toString() {
	
		return this.id + " : " + this.ano;
	}
}
