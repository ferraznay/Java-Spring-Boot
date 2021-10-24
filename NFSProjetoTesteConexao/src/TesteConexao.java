import java.util.ArrayList;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Conexao c ;
	c = Conexao.getInstance();
	c.getConnection();
	c = Conexao.getInstance();
	c.getConnection();
	
	
	//add usuario
	UserDao dao = new UserDao();
	User user = new User ("Nayara", "nayara@gmail.com");
	dao.addUsuario(user);
	
	// remove
	ArrayList<User> lista1 = dao.getListaUsuario();
	System.out.println(lista1);
	
	dao.removeUsuario(1);
	lista1= dao.getListaUsuario();
	System.out.println(lista1);
	
	//update
	User user1 = new User ("Nayara", "nayara@gmail.com");
	user.setId(1);
	dao.updateUsuario(user1);

	lista1= dao.getListaUsuario();
	System.out.println(lista1);
	}

}
