package br.edu.insper.mvc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;

/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/novoCadastro.jsp");
		dispatcher.forward(request, response);
	}

 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao;
		List<Usuario> pessoas = new ArrayList<Usuario>();
		try {
			dao = new DAO();
			Usuario pessoa = new Usuario();
			 pessoa.setNome(request.getParameter("nome"));
			 pessoa.setSenha(request.getParameter("senha"));
			 
			 
			 pessoas = dao.getLista();
			 
			 
			 boolean existe = false;
			 for (Usuario user : pessoas) {
				 if (user.getNome().contentEquals(pessoa.getNome())) {
					 existe=true;
				 }
			 }
			 if (existe==true) {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/novoCadastro.jsp");
				 request.setAttribute("errorMsg", "Nome de usu�rio j� existe. Por favor, escolha outro");
				dispatcher.forward(request, response);
				 
			 }else {
				 response.sendRedirect("Login");
				 dao.adiciona(pessoa);
			 }
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
