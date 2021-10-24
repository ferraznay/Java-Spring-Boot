package br.com.rd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Projeto2Servlet
 */
@WebServlet("/Projeto2Servlet")
public class Projeto2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Projeto2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if((request.getParameter("valor1")!= null) && (request.getParameter("valor2") != null) && (request.getParameter("valor3") != null) ) {
			if((!request.getParameter("valor1").isEmpty()) && (!request.getParameter("valor2").isEmpty()) && (!request.getParameter("valor3").isEmpty())) {
				
			}else {
				response.getWriter().println("Resultado não foi gerado pois há um campo branco");}
			int valor1 = Integer.parseInt(request.getParameter("valor1"));
			int valor2 = Integer.parseInt(request.getParameter("valor2"));
			int valor3 = Integer.parseInt(request.getParameter("valor3"));
				if(valor1 == valor2 && valor1 == valor3) {
					response.getWriter().println("O triangulo é do tipo Equilátero");				
				} else {
					if (valor1 == valor2 || valor1 == valor3 || valor2 == valor3) {
						response.getWriter().println("O triangulo é do tipo Isósceles");
					}else {
						response.getWriter().println("O triangulo é do tipo Escaleno");
					}
				}
		
			
		} else {
				response.getWriter().println("Resultado não foi gerado pois há um campo nulo");
		}
	}

}
