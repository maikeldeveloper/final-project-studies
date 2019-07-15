package servletsCliente;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteBean;
import beans.FamiliaProductoBean;
import beans.MenuSubFamiliaBean;
import beans.ProductoBean;
import clases.Cliente;
import clases.Familia;
import clases.Lin_Ped;
import clases.Pedido;
import clases.Producto;
import clases.SubFamilia;
import excepciones.MiException;

/**
 * Servlet implementation class FronTController
 */

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// COJO LA URL Y HAGO UN SPLIT PARA COGER QUE ME PIDE LA URL .../familia/subfamilia
		HttpSession session = request.getSession(true);
		if(session.getAttribute("CARRITO") == null){
			Vector <Lin_Ped> carrito = new Vector<Lin_Ped>();
			session.setAttribute("CARRITO", carrito);
		}
		String requestPage = request.getRequestURI().substring(request.getContextPath().length()).toLowerCase();
		request.setAttribute("requestPage",	requestPage);
		String templatePage = null;
		String familia = "";
		
		// ACCIONES FORMULARIOS // CONEXION DESDE LOGEO
		if(request.getParameter("accion") != null && request.getParameter("accion").equals("conectar")){
			ClienteBean clienteAutentificado = Cliente.autentificarCliente(request.getParameter("NOM_USER"), request.getParameter("PASS"));
			if (clienteAutentificado != null) {
				session.setAttribute("CLIENTE", clienteAutentificado);
				request.setAttribute("mensaje", "Bienvenido " + clienteAutentificado.getNombre() + " " + clienteAutentificado.getApellidos());
			}else{
				if( request.getParameter("nextPage") != null && request.getParameter("nextPage").equals("/carrito") )
					request.setAttribute("nextPage", "/carrito");
				request.setAttribute("mensaje", "Usuario y contrase�a erroneas");
			}
		}
		
		// INDEX
		if(requestPage.equals("/") || requestPage.equals("/index.jsp")){
			templatePage = "/Templates/index.jsp";
		}
		
		// CARRITO
		else if(requestPage.equals("/carrito")){
			// A�ADIR, ELIMINAR, PRODUCTO CARRITO
			if(request.getParameter("accion") != null){
				if(request.getParameter("accion").equals("addProduct") || request.getParameter("accion").equals("removeProduct")){
					request.getRequestDispatcher("/ControlCarrito").include(request, response);	
				}
			}
			if (session.getAttribute("CLIENTE") != null) {
				templatePage = "/Templates/Tienda/Carrito.jsp";
			}else{
				request.setAttribute("nextPage", "/carrito");
				templatePage = "/Templates/Tienda/Registro.jsp";
			}
		}
		
		// REALIZAR PEDIDO CONFIRMACION
		else if(requestPage.equals("/realizar-pedido")){
			if(session.getAttribute("CLIENTE") == null){
				request.setAttribute("mensaje", "Tiene que registrarse o conectarse como usuario");
				templatePage = "/Templates/index.jsp";
			}else{
				Vector<Lin_Ped> carrito = (Vector<Lin_Ped>)session.getAttribute("CARRITO");
				ClienteBean cliente = (ClienteBean)session.getAttribute("CLIENTE");
				if(carrito.size() < 1){
					request.setAttribute("mensaje", "No puede finalizar pedido hasta que no seleccione al  menos un articulo");
					templatePage = "/Templates/index.jsp";
				}else{
					try {
						Pedido.realizarPedido(carrito, cliente.getNom_user());
						session.setAttribute("CARRITO", null);
						request.setAttribute("mensaje", "Su pedido se ha completado correctamente, en la brevedad posible lo tendra en su domicilio");
						templatePage = "/Templates/Tienda/ConfirmacionPedido.jsp";
					} catch (MiException e) {
						request.setAttribute("mensaje", e.getMessage());
						templatePage = "/Templates/Tienda/ConfirmacionPedido.jsp";
					}
				}
			}
		}
		
		// PAGINA REGISTRO
		else if(requestPage.equals("/registro")){
			if(request.getParameter("accion") != null && request.getParameter("accion").equals("registro")){
				request.getRequestDispatcher("/Registro").include(request, response);
			}
			if (session.getAttribute("CLIENTE") != null) {
				if( request.getParameter("nextPage") != null && request.getParameter("nextPage").equals("/carrito") )
					templatePage = "/Templates/Tienda/Carrito.jsp";
				else
					templatePage = "/Templates/index.jsp";
			}else{
				if( request.getParameter("nextPage") != null && request.getParameter("nextPage").equals("/carrito") )
					request.setAttribute("nextPage", "/carrito");
				templatePage = "/Templates/Tienda/Registro.jsp";
			}	

		// PAGINA REGISTRO
		}else if(requestPage.equals("/documentacion")){
			templatePage = "/Templates/documentacion.jsp";
	
		// PAGINA PRODUCTOS
		}else{
			// A�ADIR, ELIMINAR, PRODUCTO CARRITO
			if(request.getParameter("accion") != null){
				if(request.getParameter("accion").equals("addProduct") || request.getParameter("accion").equals("removeProduct")){
					request.getRequestDispatcher("/ControlCarrito").include(request, response);	
				}
			}
			String options[] = requestPage.split("/");
			String familias[] = {"entrantes","platos", "menus","bebidas","postres" , "helados"};
			String page;
			Arrays.sort(familias);
			if (Arrays.binarySearch(familias, options[1]) >= 0) {
				// CONTENT NEXT PAGE 
				familia = options[1];
				String subfamilia = null;
				page = familia;
				if(options.length > 2){
					subfamilia = options[2].toLowerCase();
					page += "/" + subfamilia;
					request.setAttribute("subfamiliaSeleccionada", subfamilia);
				}
				
				Vector<ProductoBean> productos = Producto.getProductos(familia, subfamilia);
				Vector<MenuSubFamiliaBean> menuSubFamilia = SubFamilia.cargarMenuSubfamilia(familia);
				request.setAttribute("actualPage", page);
				request.setAttribute("menuSubFamilia", menuSubFamilia);		
				request.setAttribute("productos", productos);
				templatePage = "/Templates/Tienda/Producto.jsp";
			}
		}
		System.out.println("Hola CAracola");
		request.setAttribute("familiaSeleccionada", familia);
		Vector<FamiliaProductoBean> menuPagina = Familia.getFamilias();
		request.setAttribute("menuFamilia", menuPagina);
		request.setAttribute("requestPage", requestPage);
		request.setAttribute("controlTemplate", true);
		dispatch(request, response, templatePage);
	}
	
	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws  javax.servlet.ServletException,  java.io.IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
	    dispatcher.forward(request, response);
	}
}
