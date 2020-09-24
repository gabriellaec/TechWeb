package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;

/**
 * Servlet implementation class Ordena
 */
@WebServlet("/Ordena")
public class Ordena extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordena() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/lista.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
DAO dao;
		System.out.println("estou no ordena");

		
		try {
			List<Tarefas> tarefas = new ArrayList<Tarefas>();
			dao = new DAO();
			
			ServletContext servletContext = getServletContext();
			String name = (String) servletContext.getAttribute( "nome" );
			
			
			System.out.println("estou no ordena");
		
			String ordem=request.getParameter("ordenar");
			System.out.println(request.getParameter("ordenar"));
			
			System.out.println(ordem);
			
			if ("alfabetica".equals(ordem)) {
				tarefas = dao.orderListaTarefasAlf(name);
			}else if ("prazo".equals(ordem)) {
				tarefas = dao.orderListaTarefasDate(name);
			}
			System.out.println(ordem);

			request.setAttribute("tarefas", tarefas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/lista.jsp");
			dispatcher.forward(request, response);

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
