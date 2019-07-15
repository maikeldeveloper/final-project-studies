package servletsAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesAdmin.Tickets;

/**
 * Servlet implementation class DesAsignarReparto
 */
@WebServlet("/DesAsignarReparto")
public class DesAsignarReparto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesAsignarReparto() {
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
		Tickets.desasignarPedidos(request.getParameter("cod_tra"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Se ha dado la vuelta a los pedidos</h2>");
	}

}
