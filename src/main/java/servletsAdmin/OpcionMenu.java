package servletsAdmin;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RepartidorBeans;
import beans.TicketsBean;
import clasesAdmin.Repartidores;
import clasesAdmin.Tickets;

/**
 * Servlet implementation class OpcionMenu
 */

public class OpcionMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpcionMenu() {
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
		String opcionMenu = request.getParameter("opcionMenu");
		if (opcionMenu.equals("liquidacion")) {
			Vector<RepartidorBeans> repartidores = Repartidores.getRepartidores();
			request.setAttribute("repartidores", repartidores);
			request.getRequestDispatcher("FormLiquidacion.jsp").forward(request, response);
		}else if(opcionMenu.equals("ListarReparto")){
			Vector<TicketsBean> listadoReparto = Tickets.getTicketsRepartidor(null);
			request.setAttribute("listadoReparto", listadoReparto);
			request.getRequestDispatcher("ListadoReparto.jsp").forward(request, response);
		}else if(opcionMenu.equals("Incidencias")){
			Vector<TicketsBean> ticketsConIncidencia = Tickets.getTicketsConIncidencias(null);
			Vector<RepartidorBeans> repartidores_incidencias = Repartidores.getRepartidores();
			request.setAttribute("repartidores", repartidores_incidencias);
			request.setAttribute("ticketsConIncidencia", ticketsConIncidencia);
			request.getRequestDispatcher("Incidencias.jsp").forward(request, response);
		}
	}

}
