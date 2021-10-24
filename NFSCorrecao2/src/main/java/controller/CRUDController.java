package controller;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Container;
import model.User;
import model.UserDao;


/**
 * Servlet implementation class CRUDController
 */
@WebServlet("/CRUDController")
public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private Container cont;
	private UserDao cont;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDController() {
    	super();
        // TODO Auto-generated constructor stub
        //this.cont = new Container();
    	this.cont= new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		delete(request, response);
//		create(request, response);
//		update(request, response);
//		show(response);
		
//		for (int i = 0; i < 10; i++) {
//			create(request, response);
//		}
//		
//		
//		for (int i = 0; i <= 10; i++) {
//			//String option = request.getParameter("btnOption");
//			String option = "";
//			if ((i % 2) == 0) {
//				option = "list";
//			}else if((i % 3) == 0){
//				option = "update";
//			}else {
//				option = "delete";
//			}
			
			String option = request.getParameter("btnOption");
			//Integer i = Integer.parseInt(request.getParameter("i"));
			
			if (option == null) {
				option = "listar";
			}
			switch (option) {
				case "create":
					create(request, response);
					break;
				case "update":
					//update(request, response, i);
					update(request, response);
					break;
				case "delete": 
					//delete(request, response, i);
					delete(request, response);
					break;
				case "newform":
					showNewForm(request, response);
					break;
				case "updateform":
					showUpdateForm(request, response);
					break;
				default:
					show(request, response);
			}
//		}
		
	}
	
	private void showNewForm(HttpServletRequest tomate, HttpServletResponse alface) throws ServletException, IOException {
		RequestDispatcher disp = tomate.getRequestDispatcher("form.jsp");
		disp.forward(tomate, alface);
	}
	
	private void showUpdateForm(HttpServletRequest tomate, HttpServletResponse alface) throws ServletException, IOException {
		Integer id = Integer.parseInt(tomate.getParameter("txtId"));
		User cebola = this.cont.buscarUser(id);
		
		RequestDispatcher disp = tomate.getRequestDispatcher("form.jsp");
		
		tomate.setAttribute("user", cebola);
		disp.forward(tomate, alface);
	}
		
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("txtName");
		//String name = "Raphael";
 		User user = new User(name, "email@email.com");
		this.cont.addUser(user);
		
		
		//response.getWriter().append(this.cont.getListUser().toString());
		response.sendRedirect("CRUDController");
	}
	
	//private void update(HttpServletRequest request, HttpServletResponse response, int i) throws ServletException, IOException{
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("txtId"));
		String name = request.getParameter("txtName");
		//Integer id = i;
		//String name = "Leonardo";
		
		User user = new User(name, "email@email.com");
		user.setId(id);
		
		this.cont.updateUser(user);
		
		//response.getWriter().append(this.cont.getListUser().toString());
		response.sendRedirect("CRUDController");
	}
	
	//private void delete(HttpServletRequest request, HttpServletResponse abobrinha, int i) throws ServletException, IOException{
	private void delete(HttpServletRequest request, HttpServletResponse abobrinha) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("txtId"));		
		//Integer id = i;
				
		this.cont.removeUser(id);
		abobrinha.sendRedirect("CRUDController");
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append(this.cont.getListUser().toString());
		
		request.setAttribute("listUser", this.cont.getListaUsuario());
		RequestDispatcher disp = request.getRequestDispatcher("listTable.jsp");
		disp.forward(request, response);
	}
	

}
