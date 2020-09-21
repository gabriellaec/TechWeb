import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriaTarefa
 */
@WebServlet("/CriaTarefa")
public class CriaTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Nome da Tarefa: <input type='text' name='nome_tarefa'><br>");
		out.println("Conteúdo: <input type=‘text' name='conteudo'><br>");
		out.println("Categoria: <input type='text' name='categoria' step='0.01'><br>");
		out.println("Data de entrega: <input type='text' name='data' step='0.01'><br>");

		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao;
		try {
			dao = new DAO();
			Tarefas tarefa = new Tarefas();
			 tarefa.setNomeTarefa(request.getParameter("nome_tarefa"));
			 tarefa.setConteudo(request.getParameter("conteudo"));
			 tarefa.setCategoria(request.getParameter("categoria"));
			 tarefa.setNome_usuario("Gabi");

			 String data = request.getParameter("data");
			 System.out.println(data);
			//DateFormat format;
			 //Date formato=null;
			//Date formato = null;
			 java.util.Date date;
			 
			 try {
				 date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
				 Calendar dataEntrega = Calendar.getInstance();
				 dataEntrega.setTime(date);
				 tarefa.setData(dataEntrega);
			 }
			 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 
			 //Date date =(Date) formato.parse(data);
			 
			 dao.adicionaTarefa(tarefa);
			 PrintWriter out = response.getWriter();
			 out.println("<html><body>");
			 out.println("Adicionado: " + tarefa.getNomeTarefa());
			 out.println("</body></html>");
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
