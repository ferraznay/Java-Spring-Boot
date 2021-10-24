import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


	public class UserDao  {
		
	
		
		public UserDao() {
			
		}
		
		public void addUsuario(User newUser) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			
			try {
				PreparedStatement p = con.prepareStatement("insert into users (name, email) values (?,?)");
				p.setString(1, newUser.getNome());
				p.setString(2, newUser.getEmail());
				System.out.println(p);
				p.execute();
				System.out.println("Comando executado");
				p.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ArrayList<User> getListaUsuario(){
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			ArrayList<User> lista = new ArrayList<User>();
			
			try {
				PreparedStatement p = con.prepareStatement("select * from users");
				ResultSet r = p.executeQuery();
				while (r.next()) {
					Integer id = r.getInt("id");
					String name = r.getString("name");
					String email = r.getString("email");
					
					User u = new User (name, email);
					u.setId(id);
					lista.add(u);
					
				}
				r.close();
				p.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}
		
		
		
		public void removeUsuario (Integer id) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
						
			try {
				PreparedStatement p = con.prepareStatement("delete from users where id = ?");
				p.setInt(1, id);
				System.out.println(p);
				p.execute();
				System.out.println("Comando executado");
				p.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		
		public void updateUsuario (User updateUsuario) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			
			try {
				PreparedStatement p = con.prepareStatement("update users set name = ?, email = ? where id = ? ");
				p.setString(1, updateUsuario.getNome());
				p.setString(2, updateUsuario.getEmail());
				p.setInt(3, updateUsuario.getId());
				System.out.println(p);
				p.executeUpdate();
				System.out.println("Comando executado");
				p.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		
		
		
		
		
		

		
	
}
