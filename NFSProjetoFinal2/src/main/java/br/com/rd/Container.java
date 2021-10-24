package br.com.rd;

import java.util.ArrayList;

import java.util.List;


public class Container  {
		private ArrayList<User> listaUsuario;
		private int sequence;
		
		public Container() {
			this.listaUsuario = new ArrayList();
			this.sequence = 0;
		}
		
		public void addUsuario(User newUser) {
			this.sequence += 1;
			newUser.setId(sequence);
			this.listaUsuario.add(newUser);
		}
		
		public void removeUsuario (Integer id) {
			for (User user : this.listaUsuario) {
				if (user.getId() == id) {
					this.listaUsuario.remove(user);
					break;
				}
			}
			
		}
		
		public void updateUsuario (User updateUsuario) {
			for (User user : this.listaUsuario) {
				if (user.getId() == updateUsuario.getId()) {
					user.setNome(updateUsuario.getNome());
					user.setEmail(updateUsuario.getEmail());
					user.setPais(updateUsuario.getPais());
					break;
				}
			}
			
		}
		
		
		public ArrayList<User> getListaUsuario(){
			return this.listaUsuario;
		}
		
		public User buscarUsuario(Integer id) {
			for (User user : this.listaUsuario) {
				if (user.getId() == id) {
					 return user;
				}
			}
			return null;
		}
		
		
		
	
}
