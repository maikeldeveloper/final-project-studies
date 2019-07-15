package servletsCliente;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Lin_Ped;
import excepciones.MiException;
/**
 * Servlet implementation class ControlCarrito
 */

public class ControlCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Vector<Lin_Ped> carrito = (Vector<Lin_Ped>)session.getAttribute("CARRITO");
		String opcionRequest = (String)request.getParameter("accion");
		System.out.println("HOLA CARACOLA ad");
		if (opcionRequest.equals("addProduct")) {
			try {
				int cantidad = Integer.parseInt(request.getParameter("CANTIDAD"));
				if (cantidad>0) {
					carrito = Lin_Ped.addLin_Ped(carrito, request.getParameter("COD_PRO"), cantidad);
					request.setAttribute("mensaje", "Producto anadido a su carro");						
				}else{
					request.setAttribute("mensaje", "La cantidad no puede ser menor de 0");
				}
			} catch (java.lang.NumberFormatException e) {
				request.setAttribute("mensaje", "La cantidad introducidad tiene que ser un valor numerico");
			}
		} else if(opcionRequest.equals("removeProduct")){
			try {
				carrito = Lin_Ped.eliminarLin_Ped(carrito, request.getParameter("cod_pro"));
				request.setAttribute("mensaje", "Producto eliminado");
			} catch (MiException e) {
				request.setAttribute("mensaje", e.getMessage());
			} 
		}


	}
}
