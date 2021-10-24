package br.com.rd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeiroServlet
 */
@WebServlet("/PrimeiroServlet")
public class PrimeiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrimeiroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("Hello Servlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		if ((request.getParameter("valor1") != null) && (request.getParameter("valor2") != null) && (request.getParameter("operador") != null)) {
			if ((!request.getParameter("valor1").isEmpty()) && (!request.getParameter("valor2").isEmpty() && (!request.getParameter("operador").isEmpty()))) {
				
				int valor1 = Integer.parseInt(request.getParameter("valor1"));
				int valor2 = Integer.parseInt(request.getParameter("valor2"));
				String operador = (request.getParameter("operador"));
				
				
				Calcular calcular = new Calcular(valor1, valor2);
				int result = 0;
				

				switch (operador) {
				case ("+"):
					result = calcular.somar();
				request.setAttribute("res", result);
					break;
				case ("-"):
					result = calcular.sub();
				request.setAttribute("res", result);
					break;
				case ("*"):
					result = calcular.multiplicar();
				request.setAttribute("res", result);
					break;
				case ("/"):
					if (valor1 == 0 || valor2 == 0){
						response.getWriter().println("Não divisivel por 0");
						result = calcular.dividir();
						request.setAttribute("res", result);
					}
				
					break;
				}
				 //response.getWriter().println("Resultado = " + result);
				 
				
				request.getRequestDispatcher("/").forward(request, response);
			} else {
				response.getWriter().println("Resultado não foi gerado pois há um campo nulo");
			}

		} else {
			response.getWriter().println("Resultado não foi gerado pois há um campo nulo");
		}

	}

}
