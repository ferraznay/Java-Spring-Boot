package br.com.rd;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ProjetoFinal2
 */
@WebServlet("/ProjetoFinal2")
public class ProjetoFinal2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Container cont;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjetoFinal2() {
        super();
        this.cont = new Container();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String option = request.getParameter("btnOption");
		
		if (option == null) {
			option = "listar";
		}
		switch (option) {
			case "create":
				create(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "delete": 
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
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("form.jsp");
		disp.forward(request, response);
	}
	
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = this.cont.buscarUsuario(id);
		
		RequestDispatcher disp = request.getRequestDispatcher("form.jsp");
		
		request.setAttribute("user", user);
		disp.forward(request, response);
	}
		
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
 		User user = new User(nome, email, pais);
		this.cont.addUsuario(user);
		
		response.sendRedirect("ProjetoFinal2");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");	
		
		User user = new User(nome, email, pais);
		user.setId(id);
		
		this.cont.updateUsuario(user);
		
		response.sendRedirect("ProjetoFinal2");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));		
				
		this.cont.removeUsuario(id);
		response.sendRedirect("ProjetoFinal2");
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listaUsuario", this.cont.getListaUsuario());
		RequestDispatcher disp = request.getRequestDispatcher("listTable.jsp");
		disp.forward(request, response);
	}
	

}