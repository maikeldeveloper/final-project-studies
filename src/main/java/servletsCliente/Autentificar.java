package servletsCliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteBean;
import clases.Cliente;
/**
 * Servlet implementation class Autentificar
 */

public class Autentificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autentificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteBean clienteAutentificado = Cliente.autentificarCliente(request.getParameter("NOM_USER"), request.getParameter("PASS"));
		if (clienteAutentificado != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("CLIENTE", clienteAutentificado);
		}else{
			// MANDAR A REGISTRO
			System.out.println("ERROR AUTENTIFICARSE");
			request.setAttribute("mensaje", "Usuario y contraseña erroneas");
		}
	}

}
