

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
 * Servlet implementation class ListaTarefa
 */
@WebServlet("/ListaTarefa")
public class ListaTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaTarefa() {
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
				
				List<Tarefas> tarefas = dao.getListaTarefas();
				PrintWriter out = response.getWriter();
				out.println("<html><body><table border='1'>");
				out.println("<tr>"
				+ "<td>Nome Tarefa</td>" +
				 "<td>Conteudo</td>"+
				 "<td>Data</td>"+
				 "<td>Categoria</td>"+
				 "<td>Nome Usuario</td>"
				 + "</tr>");
			
				for (Tarefas tarefa : tarefas) {
				 out.println("<tr><td>" + tarefa.getNomeTarefa() + "</td>");
				 out.println("<td>" + tarefa.getConteudo() + "</td>");
				 out.println("<td>" + tarefa.getData().getTime() + "</td>");
				 out.println("<td>" + tarefa.getCategoria() + "</td>");
				 out.println("<td>" + tarefa.getNome_usuario() + "</td><tr>");

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



