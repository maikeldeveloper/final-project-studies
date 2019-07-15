package servletsAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EncargadoBean;
import beans.TrabajadorBean;
import clasesAdmin.Tickets;
import excepciones.MiException;

/**
 * Servlet implementation class AsignarRepartoAjax
 */
@WebServlet("/AsignarRepartoAjax")
public class AsignarRepartoAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignarRepartoAjax() {
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
		TrabajadorBean encargado = (TrabajadorBean) session.getAttribute("ENCARGADO");
		System.out.println(encargado.getCod_tra());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Tickets.asignarPedidos(request.getParameter("pedido1"), 
									request.getParameter("pedido2"), 
									encargado.getCod_tra(), 
									request.getParameter("cod_tra"));
			out.println("<h2>Los pedidos han sido asignados</h2>");
		} catch (MiException e) {
			out.println("<h2>" + e.getMessage() + "</h2>");
		}
	}

}
