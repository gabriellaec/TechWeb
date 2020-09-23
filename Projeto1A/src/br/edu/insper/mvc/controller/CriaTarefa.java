package br.edu.insper.mvc.controller;
import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;

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
		        
		      ServletContext servletContext = getServletContext();

			 String name = (String) servletContext.getAttribute( "nome" );

			 tarefa.setNome_usuario(name);

			 String data = request.getParameter("data");
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
			 
			 
			 
			 dao.adicionaTarefa(tarefa);
			 
			 response.sendRedirect("ListaTarefa");
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
