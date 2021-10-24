package controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Carros;
import model.CarrosDao;
import model.Ipva;
import model.IpvaDao;

/**
 * Servlet implementation class CRUDController
 */
@WebServlet("/CRUDControllerCarro")
public class CRUDControllerCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarrosDao cont;
	private IpvaDao ipva;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDControllerCarro() {
    	super();
        // TODO Auto-generated constructor stub
        this.cont = new CarrosDao();
        this.ipva = new IpvaDao();
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

			
			String option = request.getParameter("btnOption");
			
			if (option == null) {
				option = "listar";
			}
			switch (option) {
				case "create":
					create(request, response);
					break;
				case "create2":
					create2(request, response);
					break;
				case "update":
					update(request, response);
					break;
				case "update2":
					update2(request, response);
					break;
				case "delete": 
					delete(request, response);
					break;
				case "delete2": 
					delete2(request, response);
					break;
				case "newform":
					showNewForm(request, response);
					break;
				case "newform2":
					showNewForm2(request, response);
					break;
				case "updateform":
					showUpdateForm(request, response);
					break;
				case "updateform2":
					showUpdateForm2(request, response);
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
		Integer id = Integer.parseInt(request.getParameter("txtId"));
		Carros carros = this.cont.buscarCarro(id);
		
		RequestDispatcher disp = request.getRequestDispatcher("form.jsp");
		
		request.setAttribute("carro", carros);
		disp.forward(request, response);
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String model = request.getParameter("model");
		Integer ano = Integer.parseInt(request.getParameter("ano"));
 		Carros carros = new Carros(model, ano);
		this.cont.cadastrar(carros);
		
		
		response.sendRedirect("CRUDControllerCarro");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("txtId"));
		String model = request.getParameter("model");
		Integer ano = Integer.parseInt(request.getParameter("ano"));
	
		
		Carros carros = new Carros(model , ano);
		carros.setId(id);
		
		this.cont.updateCarro(carros);
		
		response.sendRedirect("CRUDControllerCarro");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("txtId"));		
				
		this.cont.removeCarro(id);
		response.sendRedirect("CRUDControllerCarro");
	}
	
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listCarro", this.cont.getListaCarro());
		request.setAttribute("listIpva", this.ipva.getListaIpva());
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		
		disp.forward(request, response);
	}
	
	
	//IPVA
	
	
	private void showNewForm2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("formIpva.jsp");
		disp.forward(request, response);
	}
	
	private void showUpdateForm2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Ipva ipva = this.ipva.buscarIpva(id);
		
		RequestDispatcher disp = request.getRequestDispatcher("formIpva.jsp");
		
		request.setAttribute("listIpva", ipva);
		disp.forward(request, response);
	}
		

	private void create2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		Integer ano = Integer.parseInt(request.getParameter("ano2"));
 		Ipva ipva = new Ipva(ano);
		this.ipva.addIpva(ipva);
		
		
		response.sendRedirect("CRUDControllerCarro");
	}
	

	
	private void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer ano = Integer.parseInt(request.getParameter("ano2"));
			
		Ipva ipva = new Ipva(ano);
		ipva.setId(id);
		
		this.ipva.updateIpva(ipva);
		
		response.sendRedirect("CRUDControllerCarro");
	}
	

	
	private void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));		
				
		this.ipva.removeIpva(id);
		response.sendRedirect("CRUDControllerCarro");
	}
	

	

}
