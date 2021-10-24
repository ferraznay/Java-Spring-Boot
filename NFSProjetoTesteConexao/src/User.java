
public class User {
	private	Integer id;
	private String name;
	private String email;
	public User(String name, String email) {
		super();
		
		this.name = name;
		this.email = email;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return name;
	}

	public void setNomer(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setCnpj(String email) {
		this.email = email;
	}


	
		
	public String toString() {
		return this.id + " : " + this.name + this.email;
	}
	

	
	
}
