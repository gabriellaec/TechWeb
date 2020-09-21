package br.edu.insper.gabriellaec;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Atualiza
 */
@WebServlet("/Atualiza")
public class Atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atualiza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Tarefas tarefa = new Tarefas();
		tarefa.setId(Integer.valueOf(request.getParameter("id")));
		tarefa.setNomeTarefa(request.getParameter("nome_tarefa"));
		tarefa.setConteudo(request.getParameter("conteudo"));
		tarefa.setCategoria(request.getParameter("categoria"));
		tarefa.setNome_usuario(request.getParameter("nome_usuario"));
		
		String nascimento = request.getParameter("data");
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		
		tarefa.setData(dataNascimento);
		try {
			dao.altera(tarefa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Atualizado: " + tarefa.getNomeTarefa());
		out.println("</body></html>");
		response.sendRedirect("http://localhost:8080/ProjUm/ListaTarefa");
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
