package servletsCliente;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteBean;
import conexionBBDD.*;
import clases.Cliente;
import excepciones.MiException;
/**
 * Servlet implementation class Registro
 */

public class Registro extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexion;
		
		System.out.println(getServletContext().getInitParameter("url"));
		System.out.println(getServletContext().getInitParameter("user"));
		System.out.println(getServletContext().getInitParameter("pass"));
		
		
		Cliente clienteComodin = new Cliente();
		ClienteBean clienteRegistrado = new ClienteBean();
		try {
			clienteRegistrado = clienteComodin.insertarClientes(request.getParameter("NOM_USER"), 
																request.getParameter("PASS"), 
																request.getParameter("PASS_R"),
																request.getParameter("NOMBRE"),
																request.getParameter("APELLIDOS"), 
																request.getParameter("DIRECCION"), 
																request.getParameter("NUMERO"), 
																request.getParameter("PISO"),
																request.getParameter("LETRA"),
																request.getParameter("ESCALERA"),
																request.getParameter("COD_POSTAL"),
																request.getParameter("TELEFONO"));
			
			HttpSession session=request.getSession(true);
			session.setAttribute("CLIENTE",clienteRegistrado);
			request.setAttribute("mensaje", "Bienvenido a Shelron " + clienteRegistrado.getNombre() + " " + clienteRegistrado.getApellidos());

		} catch (MiException e) {
			request.setAttribute("mensaje", e.getMessage());
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request,  response);
	}
}
