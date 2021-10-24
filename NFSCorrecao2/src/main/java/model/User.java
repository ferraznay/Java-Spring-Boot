package model;

public class User {
	private Integer id;
	private String name;
	private String email;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User (String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		//return "(" + this.id + ", " + this.name + ")";
		return this.id + " : " + this.name;
	}

}
