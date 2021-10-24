package model;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Conexao;

public class CarrosDao {

	
	public CarrosDao() {
		
	}
	
	public void cadastrar(Carros carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into carros (model, ano) values (?,?)");
			p.setString(1, carro.getModel());
			p.setInt(2, carro.getAno());
			System.out.println(p);
			p.execute();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Carros> getListaCarro(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Carros> lista = new ArrayList<Carros>();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from carros");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Integer id = r.getInt("id");
				String model = r.getString("model");
				Integer ano= r.getInt("ano");
				
				Carros car = new Carros (model, ano);
				car.setId(id);
				lista.add(car);
			}
			
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}
	
	
	public void removeCarro (Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from carros where id = ?");
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

		public void updateCarro(Carros updateCarro) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			
			try {
				PreparedStatement p = con.prepareStatement("update carros set model = ?, ano = ? where id = ? ");
				p.setString(1, updateCarro.getModel());
				p.setInt(2, updateCarro.getAno());
				p.setInt(3, updateCarro.getId());
				System.out.println(p);
				p.executeUpdate();
				System.out.println("Comando executado");
				p.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		public Carros buscarCarro(Integer id) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			ArrayList<Carros> lista = new ArrayList<Carros>();
			Carros car = null;
			
			try {
				PreparedStatement p = con.prepareStatement("select * from carros where id = ?");
				p.setInt(1, id);
				System.out.println(p);
				ResultSet r = p.executeQuery();
				
				while (r.next()) {
					Integer id2 = r.getInt("id");
					String model = r.getString("model");
					Integer ano = r.getInt("ano");
					
					car = new Carros (model, ano);
					car.setId(id);
				}
				r.close();
				p.close();
				System.out.println("Comando executado");
				return car;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return car;
		}
		

	
}
