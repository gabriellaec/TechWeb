package br.edu.insper.gabriellaec;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request,
			 HttpServletResponse response)
			 throws ServletException, IOException {
			DAO dao;
			try {
				dao = new DAO();
				
				List<Usuario> pessoas = dao.getLista();
				PrintWriter out = response.getWriter();
				out.println("<html><body><table border='1'>");
				out.println("<tr><td>ID</td><td>Nome</td>" +
				 "<td>Senha</td></tr>");
				for (Usuario pessoa : pessoas) {
				 out.println("<tr><td>" + pessoa.getId() + "</td>");
				 out.println("<td>" + pessoa.getNome() + "</td>");
				 out.println("<td>" + pessoa.getSenha() + "</td>");
				}
				out.println("</table></body></html>");

				dao.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 }

}
