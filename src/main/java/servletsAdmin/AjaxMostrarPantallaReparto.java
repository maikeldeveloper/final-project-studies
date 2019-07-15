package servletsAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PedidoBean;
import beans.RepartidorBeans;
import beans.TicketsBean;
import clases.Pedido;
import clasesAdmin.Repartidores;
import clasesAdmin.Tickets;

/**
 * Servlet implementation class AjaxControlReparto
 */
@WebServlet("/AjaxMostrarPantallaReparto")
public class AjaxMostrarPantallaReparto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


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
		Vector <PedidoBean> pedidosPendientes = Pedido.obtenerPedidosPendientes();
		Vector <RepartidorBeans> repartidores = Repartidores.getRepartidores();
		Vector <TicketsBean> ticketsEnReparto = Tickets.getTicketsEnReparto();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String apellidos = null;
		
		/* MOSTRAR PEDIDOS */
		out.println("<div id='pedidosControlReparto'>");
		out.println("<h2>Pedidos en espera</h2>");
		for(PedidoBean pedido : pedidosPendientes){
			out.println("<div class='ck-button'>");
			out.println("<label>"
					+ "<input type='checkbox' name='pedidos' value='"+pedido.getCod_ped()+"' onClick='controlDosChecked()'><span>nº. " + pedido.getCod_ped() +" | " + pedido.getDia_hora().substring(10,16) + " | "+pedido.getCliente().getDireccion() + ", "+ pedido.getCliente().getNumero()+ "</span>"
					+ "</label>");
			out.println("</div>");
		}
		out.println("</div>");
		
		/* MOSTRAR PEDIDOS/TICKETS EN REPARTO */
		out.println("<div id='ticketsControlReparto'>");
		out.println("<h2>Pedido en reparto</h2>");
		out.println("<ul>");
		for(TicketsBean ticket : ticketsEnReparto){
			out.println("<li>nº. "+ ticket.getCod_tic() +" |  "+ ticket.getHora_salida().substring(10,16) +" | "+ ticket.getCliente().getDireccion() +", "+ ticket.getCliente().getNumero() +"</li>");
		}
		out.println("</ul>");
		out.println("</div>");
		
		/* MOSTRAR REPARTIDORES DISPONIBLES/NO DIPONIBLES */
		out.println("<div id='repartidoresControlReparto'>");
		out.println("<h2>Repartidores</h2>");
		for(RepartidorBeans repartidor: repartidores){
			if (repartidor.getDisponible().equals("S")) {
				if(repartidor.getApellidos().length()>18){ apellidos = repartidor.getApellidos().substring(0,18);} else{ apellidos = repartidor.getApellidos();}
				out.println("<a  class='button' onClick='asignarReparto("+ repartidor.getCod_tra() +")'>"+
						repartidor.getNombre() +" "+ apellidos +"</a>"
								+ "<div class='vuelta disable' disable></div>");
			}else{
				if(repartidor.getApellidos().length()>18){ apellidos = repartidor.getApellidos().substring(0,18);} else{ apellidos = repartidor.getApellidos();}
				out.println("<div  class='button disable'>"+
						repartidor.getNombre() +" "+ apellidos +"</div>"
								+ "<a class='vuelta' onClick='desasignarReparto("+ repartidor.getCod_tra() +")'></a>");
			}
		}
		out.println("</div>");
	}

}
