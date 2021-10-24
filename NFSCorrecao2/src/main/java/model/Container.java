package model;
import java.util.ArrayList;

public class Container {
	private ArrayList<User> listUser;
	private Integer sequence;
	
	public Container() {
		this.listUser = new ArrayList();
		this.sequence = 0;
	}
	
	public void addUser(User newUser) {
		this.sequence += 1;
		newUser.setId(sequence);
		this.listUser.add(newUser);
	}
	
	public void removeUser(Integer id) {
		for (User user : this.listUser) {
			if (user.getId() == id) {
				this.listUser.remove(user);
				break;
			}
		}
	}
	
	//public void updateUser(Integer id, String newName) {
	public void updateUser(User updateUser) {
		for (User user : this.listUser) {
			if (user.getId() == updateUser.getId()) {
				user.setName(updateUser.getName());
				break;
			}
		}
	}
	
	public ArrayList<User> getListUser(){
		return this.listUser;
	}
	
	public User buscarUser(Integer id) {
		for (User user : this.listUser) {
			if (user.getId() == id) {
				 return user;
			}
		}
		return null;
	}
	
	
	

}
