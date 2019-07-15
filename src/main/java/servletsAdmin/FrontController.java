package servletsAdmin;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BalanceBean;
import beans.EncargadoBean;
import beans.IncidenciaBean;
import beans.Lin_PedBean;
import beans.RepartidorBeans;
import beans.TicketsBean;
import beans.TrabajadorBean;
import clasesAdmin.Balance;
import clasesAdmin.Encargados;
import clasesAdmin.Incidencias;
import clasesAdmin.Repartidores;
import clasesAdmin.Tickets;
import excepciones.MiException;


/**
 * Servlet implementation class FrontControllerAdmin
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String requestOption = request.getPathInfo();
		String option = request.getRequestURI().substring(request.getContextPath().length());
		String pagina;
		try {
			pagina = option.split("/")[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			pagina = "/";
		}
		
		String templatePage = "";
		
		System.out.println("requestOption: " + requestOption);
		System.out.println("option: " + option);
		System.out.println("split " + pagina );
		
		
		
		// CONECTAR
		if( requestOption != null && requestOption.equalsIgnoreCase("/conectar")){
			TrabajadorBean encargado = Encargados.autentificarEncargado(request.getParameter("COD_TRA"), request.getParameter("PASS"));
			if (encargado==null) {
				request.setAttribute("mensaje", "Datos incorrectos");
				System.out.println("entra");
				templatePage = "/Templates/Admin/Conectar.jsp";
			}else{
				session.setAttribute("ENCARGADO", encargado);
				templatePage = "/Templates/Admin/index.jsp";
			}
		}
		
		
		
		// CONTROL SESION DE ADMIN PARA ACCEDER A LAS DEMAS OPCIONES
		if(session.getAttribute("ENCARGADO") == null){
			templatePage = "/Templates/Admin/Conectar.jsp";
		}else{
			TrabajadorBean encargado = (TrabajadorBean) session.getAttribute("ENCARGADO");
			request.setAttribute("nombreEncargado", encargado.getNombre() + " " + encargado.getApellidos());
			
			// INDEX ADMIN  // path = "/admin" 
			if(option.equalsIgnoreCase("/admin") || option.equalsIgnoreCase("/admin/")){
				request.setAttribute("nombreEncargado", encargado.getNombre() + " " + encargado.getApellidos());
				templatePage = "/Templates/Admin/index.jsp";
			}
			
			// CONTROL REPARTO
			else if(option.equals("/admin/controlreparto")) {
				templatePage = "/Templates/Admin/PaginaReparto.jsp";
			}
			
			// LIQUIDACION
			else if(option.startsWith("/admin/liquidacion")){	
				if(option.equals("/admin/liquidacion")){			
					Vector<RepartidorBeans> repartidores = Repartidores.getRepartidores();
					request.setAttribute("repartidores", repartidores);
					templatePage ="/Templates/Admin/FormLiquidacion.jsp";
				}else{
					String cod_rep = option.substring("/admin/liquidacion/".length());
					System.out.println("codigo repartidor " + cod_rep);
					Vector<TicketsBean> ticketsRepartidor = Tickets.getTicketsRepartidor(cod_rep);
					request.setAttribute("ticketsRepartidor", ticketsRepartidor);
					templatePage ="/Templates/Admin/RepartoRepartidor.jsp";
				}
			}
			
			// LISTADO REPARTO
			else if(option.equals("/admin/listar-reparto")|| option.equals("/admin/listar-reparto/")){
				if(request.getParameter("num_pedido") != null){
					try {
						int numeroPedido = Integer.parseInt(request.getParameter("num_pedido")) ;
						
						// TIENE INCIDENCIA TRUE ENVIO A INCIDENCIA
						boolean incidencia = Incidencias.checkTicket(numeroPedido);
						if (incidencia) {
							IncidenciaBean incidencia_pedido = Incidencias.getDetalleIncidencia(numeroPedido);
							request.setAttribute("incidencia", incidencia_pedido);
							templatePage = "/Templates/Admin/DetalleIncidencias.jsp";
						}else{
							TicketsBean pedidoSeleccionado = Tickets.getTicketByCodTic(numeroPedido);
							if(pedidoSeleccionado != null){
								request.setAttribute("pedidoSeleccionado", pedidoSeleccionado);
								templatePage="/Templates/Admin/DetallePedido.jsp";
							}else{
								request.setAttribute("mensaje", "No existe un pedido con el numero" + request.getParameter("num_pedido"));
								Vector<TicketsBean> listadoReparto = Tickets.getTicketsRepartidor(null);
								request.setAttribute("listadoReparto", listadoReparto);
								templatePage="/Templates/Admin/ListadoReparto.jsp";
							}
						}
					} catch (NumberFormatException e) {
						request.setAttribute("mensaje", "Introduzaca el numero numero de pedido");
						Vector<TicketsBean> listadoReparto = Tickets.getTicketsRepartidor(null);
						request.setAttribute("listadoReparto", listadoReparto);
						templatePage="/Templates/Admin/ListadoReparto.jsp";
					}		
				}else{
					Vector<TicketsBean> listadoReparto = Tickets.getTicketsRepartidor(null);
					request.setAttribute("listadoReparto", listadoReparto);
					templatePage="/Templates/Admin/ListadoReparto.jsp";
				}
			}
			
			// INCIDENCIAS
			else if(option.startsWith("/admin/incidencias")){
				int numeroIncidencia = -1;
				if(option.equals("/admin/incidencias") || option.equals("/admin/incidencias/")){
					templatePage = "/Templates/Admin/Incidencias.jsp";
				
				// BUCAR INCIDENCIA
				}else if(option.equals("/admin/incidencias/incidencia")){
					if(request.getParameter("numero_ticket_buscar") == null){
						request.setAttribute("mensaje", "Tiene que introducir un numero de Ticket");
						templatePage = "/Templates/Admin/Incidencias.jsp";
					}else{
						try {
							int numeroPedido = Integer.parseInt(request.getParameter("numero_ticket_buscar")) ;
							IncidenciaBean incidencia = Incidencias.getDetalleIncidencia(numeroPedido);
							request.setAttribute("incidencia", incidencia);
							templatePage = "/Templates/Admin/DetalleIncidencias.jsp";
						} catch (NumberFormatException e) {
							request.setAttribute("mensaje", "Tiene que introducir un numero de Ticket");
							templatePage = "/Templates/Admin/Incidencias.jsp";
						}	
					}
				
				// MOSTRAR CREAR INCIDENCIA	
				}else if(option.startsWith("/admin/incidencias/crear-incidencia")){	
					try {
						numeroIncidencia = Integer.parseInt(option.substring("/admin/incidencias/crear-incidencia/".length()));
					} catch (NumberFormatException e) {
						numeroIncidencia = -1;
					} catch (StringIndexOutOfBoundsException e) {
						numeroIncidencia = -1;
					}
					if(request.getParameter("numero_ticket_crear") != null && request.getParameter("numero_ticket_crear").equals("") && numeroIncidencia == -1){
						request.setAttribute("mensaje", "Tiene que introducir un numero de Ticket");
						templatePage = "/Templates/Admin/Incidencias.jsp";
					}else{
						try {
							if (numeroIncidencia == -1) {
								numeroIncidencia = Integer.parseInt(request.getParameter("numero_ticket_crear")) ;
							}
							TicketsBean ticketIncidencia = Tickets.getTicketByCodTic(numeroIncidencia);
							if (ticketIncidencia == null) {
								request.setAttribute("mensaje", "No existe un pedido con el numero: " + numeroIncidencia);
								templatePage = "/Templates/Admin/Incidencias.jsp";
							}else{
								request.setAttribute("ticketIncidencia", ticketIncidencia);
								request.setAttribute("ticket", ticketIncidencia);
								templatePage = "/Templates/Admin/CrearIncidencias.jsp";
							}
						} catch (NumberFormatException e) {
							request.setAttribute("mensaje", "Tiene que introducir un numero de Ticket");
							templatePage = "/Templates/Admin/Incidencias.jsp";
						}	
					}
					
				// CREAR INCIDENCIA
				}else if(option.equals("/admin/incidencias/grabar-incidencia-ticket")){	
					System.out.println("ENTRA");
					numeroIncidencia = Integer.parseInt(request.getParameter("numeroCodTic"));
					IncidenciaBean incidencia = new IncidenciaBean();
					TicketsBean ticketComodin = new TicketsBean(); 
					Lin_PedBean linPedComodin;
					Vector<Lin_PedBean> lineas = new Vector<Lin_PedBean>();
					int cantidad = 0;
					int cantidad_antigua = 0;
					float precio = 0;
					boolean control = true;
					String nombreProducto;
					String mensaje = "";
					Enumeration<String> parameterNames = request.getParameterNames();
					while (parameterNames.hasMoreElements()) {
						String paramName = parameterNames.nextElement();
						if(!paramName.equals("numeroCodTic") && !paramName.equals("descripcion")){
				            linPedComodin = new Lin_PedBean();
				            linPedComodin.setCod_pro(Integer.parseInt(paramName));
				            String[] paramValues = request.getParameterValues(paramName);
				            nombreProducto = paramValues[4];
				            try {
				            	cantidad = Integer.parseInt(paramValues[0]);
				            	precio = Float.parseFloat(paramValues[1]);
				            	cantidad_antigua = Integer.parseInt(paramValues[2]);
				            	linPedComodin.setCantidad(cantidad);
				            	linPedComodin.setPrecio_uni(precio);
				            } catch (NumberFormatException e) {
								TicketsBean ticketIncidencia = Tickets.getTicketByCodTic(numeroIncidencia);
								request.setAttribute("mensaje", "Los campos solo pueden rellenarse con numeros");
								templatePage = "/Templates/Admin/CrearIncidencias.jsp";	
							} 
				            if (cantidad < 0 || precio < 0) {
				            	control = false;
				            	mensaje += "Las cantidades/precio del codigo articulo " + nombreProducto + " no pueden ser negativas ";
							}	
			            lineas.add(linPedComodin);
			            }           
			        }
					ticketComodin.setLineasPedido(lineas);
					ticketComodin.setCod_tic(numeroIncidencia);
					incidencia.setTicketIncindecia(ticketComodin);
					incidencia.setDescripcion(request.getParameter("descripcion"));
					incidencia.setCod_ped(numeroIncidencia);
					if (!control) {
						request.setAttribute("mensaje", mensaje);
						templatePage = "/Templates/Admin/CrearIncidencias.jsp";
					}else{
						request.setAttribute("mensaje", mensaje);
						try {
							boolean incidenciaCreada = Incidencias.creaIncidencia(incidencia);
							request.setAttribute("mensaje", "La incidencia ha sido registrada");
							templatePage = "/Templates/Admin/Incidencias.jsp";
						} catch (MiException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							request.setAttribute("mensaje", "No se ha podido crear la incidencia");
							templatePage = "/Templates/Admin/Incidencias.jsp";
						}
					}
					
				}else if(request.getParameter("opcion_menu_incidencia") != null){
					String requestOpcionMenuIncidencia = request.getParameter("opcion_menu_incidencia");
					if(requestOpcionMenuIncidencia.equals("buscarIncidenciaPorCod_Tic")){
						System.out.println("/Templates/Admin/buscar/IncidenciaPorCod_Tic");
					}else if(requestOpcionMenuIncidencia.equals("crearIncidenciaPorCod_Tic")){
						if(!request.getParameter("numero_ticket_crear").equals("")){
							int numero_ticket_crear = Integer.parseInt(request.getParameter("numero_ticket_crear"));
							TicketsBean ticketIncidencia = Tickets.getTicketByCodTic(numero_ticket_crear);
							request.setAttribute("ticketInformation", ticketIncidencia);
							request.getRequestDispatcher("/Templates/Admin/FormCrearIncidencia.jsp").forward(request, response);
						}else{
							System.out.println("No has pasado ningun valor");
							request.setAttribute("mensajes", "Tiene que introducir el codigo del ticket");
							request.getRequestDispatcher("/incidencias/").forward(request, response);
						}
					}
				}
				
				// DATOS REQUERIDOS SEGUN TEMPLATE
				if(templatePage.equals("/Templates/Admin/Incidencias.jsp")){
					Vector<TicketsBean> ticketsConIncidencia = Tickets.getTicketsConIncidencias(null);
					Vector<RepartidorBeans> repartidores_incidencias = Repartidores.getRepartidores();
					request.setAttribute("repartidores", repartidores_incidencias);
					request.setAttribute("ticketsConIncidencia", ticketsConIncidencia);
				}
			}
			
			// BALANCE
			else if(option.equals("/admin/balance")){
				BalanceBean balance = Balance.getBalance();
				request.setAttribute("balance", balance);
				templatePage = "/Templates/Admin/Balance.jsp";
			}
			
			// DESCONECTAR
			else if(option.equals("/admin/desconectar")){
				request.setAttribute("mensaje", "Hasta pronto " + encargado.getNombre() + " " + encargado.getApellidos());
				session.invalidate();
				templatePage = "/Templates/Admin/Conectar.jsp";
			}
		} // FIN CONTROL SESSION
		
		request.setAttribute("controlTemplate", true);
		request.setAttribute("pagina", pagina);
		dispatch(request,response,templatePage);	
	}
	
	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws  javax.servlet.ServletException,  java.io.IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
	    dispatcher.forward(request, response);
	}

}
