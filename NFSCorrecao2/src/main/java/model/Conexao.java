package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String url = "jdbc:mysql://localhost:3306/crud";
	private String username = "admin";
	private String password = "admin";
	private static Connection connection;
	private static Conexao instance = null;
	


	private Conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver carregado");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver não carregador " + e.getMessage()); 
		}
		
	}
	
	public static Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
			System.out.println("criando instancia");
		}
		System.out.println("retornando instancia");
		return instance;
	
	}
	
	
	public Connection getConnection() {
		
			try {
				if ((connection == null) || (connection.isClosed())) {
					connection = DriverManager.getConnection(this.url,this.username,this.password);
					System.out.println("Conexão estabelecida");
					return connection;
				} 
			}catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Conexão não estabelecida: " + e.getMessage());
			
				}
				return connection;
								
		}
	
				
	public void finalize() {
		System.out.println("Destroy");
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}