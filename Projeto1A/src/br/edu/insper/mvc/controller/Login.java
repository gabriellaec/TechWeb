package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("nome");
        String pass = request.getParameter("senha");
        
        getServletContext().setAttribute( "nome", email );
        
        try {
			if(dao.checkUser(email, pass))
			{
			    RequestDispatcher rs = request.getRequestDispatcher("ListaTarefa");
			    System.out.println("redirecinouu");
			    rs.forward(request, response);
			}
			else
			{
			   out.println("Usuário ou senha incorretos");
			   RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/view/index.jsp");
			   rs.include(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
