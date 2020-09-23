package br.edu.insper.mvc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("Atualiza.jsp");
		dispatcher.forward(request, response);
		 
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
		
		ServletContext servletContext = getServletContext();

		 String name = (String) servletContext.getAttribute("nome");

		 tarefa.setNome_usuario(name);


		tarefa.setId(Integer.valueOf(request.getParameter("id")));
		tarefa.setNomeTarefa(request.getParameter("nome_tarefa"));
		tarefa.setConteudo(request.getParameter("conteudo"));
		tarefa.setCategoria(request.getParameter("categoria"));
		
		String nascimento = request.getParameter("data");
		System.out.println(nascimento);
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
			
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			
			tarefa.setData(dataNascimento);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dao.altera(tarefa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		response.sendRedirect("ListaTarefa");
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
