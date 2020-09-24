package br.edu.insper.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.insper.mvc.controller.Tarefas;
import br.edu.insper.mvc.controller.Usuario;

public class DAO {
	private Connection connection = null;
	
	public DAO() throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(
	"jdbc:mysql://localhost/projetoum", "root", "gabi8009");
	}
	
	public List<Usuario> getLista() throws SQLException {
		List<Usuario> pessoas = new ArrayList<Usuario>();
		PreparedStatement stmt = connection.
		prepareStatement("SELECT * FROM Usuario");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario pessoa = new Usuario();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setSenha(rs.getString("senha"));
			pessoas.add(pessoa);
		}
		rs.close();
		stmt.close();
		
		return pessoas;
		}
	
	public List<Tarefas> getListaTarefas(String name) throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		String sql =("SELECT * FROM Tarefas WHERE nome_usuario=?");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,name);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setConteudo(rs.getString("conteudo"));
			tarefa.setNomeTarefa(rs.getString("nome_tarefa"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			
			tarefa.setCategoria(rs.getString("categoria"));
			tarefa.setNome_usuario(rs.getString("nome_usuario"));

			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		
		return tarefas;
		}
	
	
	public List<Tarefas> searchListaTarefas(String name, String nome_tarefa) throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		String sql =("SELECT * FROM Tarefas WHERE nome_usuario=? AND nome_tarefa=?");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setString(2,nome_tarefa);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setConteudo(rs.getString("conteudo"));
			tarefa.setNomeTarefa(rs.getString("nome_tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setCategoria(rs.getString("categoria"));
			tarefa.setNome_usuario(rs.getString("nome_usuario"));

			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		
		return tarefas;
		}
	
	
	public List<Tarefas> orderListaTarefasAlf(String name) throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		String sql =("SELECT * FROM Tarefas WHERE nome_usuario=? ORDER BY nome_tarefa ASC");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,name);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setConteudo(rs.getString("conteudo"));
			tarefa.setNomeTarefa(rs.getString("nome_tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setCategoria(rs.getString("categoria"));
			tarefa.setNome_usuario(rs.getString("nome_usuario"));

			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		
		return tarefas;
		}
	
	
	public List<Tarefas> orderListaTarefasDate(String name) throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		String sql =("SELECT * FROM Tarefas WHERE nome_usuario=? ORDER BY date(data)desc");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,name);

		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setConteudo(rs.getString("conteudo"));
			tarefa.setNomeTarefa(rs.getString("nome_tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setCategoria(rs.getString("categoria"));
			tarefa.setNome_usuario(rs.getString("nome_usuario"));

			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		
		return tarefas;
		}
	
	
	public List<Tarefas> filterTarefas(String categoria, String name) throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		String sql =("SELECT * FROM Tarefas WHERE categoria=? AND nome_usuario=?");
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,categoria);
		stmt.setString(2,name);


		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setConteudo(rs.getString("conteudo"));
			tarefa.setNomeTarefa(rs.getString("nome_tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setCategoria(rs.getString("categoria"));
			tarefa.setNome_usuario(rs.getString("nome_usuario"));

			tarefas.add(tarefa);
		}
		rs.close();
		stmt.close();
		
		return tarefas;
		}
	
	
	public void search(String conteudo) throws SQLException {
		String sql = "SELECT * FROM Tarefas WHERE conteudo=?";
		boolean st =false;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,conteudo);
			stmt.execute();
		}catch(Exception e) {
            e.printStackTrace();
        }   
	}
	
	public void adiciona(Usuario pessoa) throws SQLException {
		
		
		String sql = "INSERT INTO Usuario" +
		"(nome,senha) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,pessoa.getNome());
		stmt.setString(2,pessoa.getSenha());
		
		stmt.execute();
		stmt.close();
		}
	
	public boolean checkRepeat(Usuario pessoa) throws SQLException {
		
		String sql = "SELECT COUNT(*) as Qtde FROM Usuario WHERE nome=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,pessoa.getNome());
		
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String Countrow = rs.getString(1);
		System.out.println(Countrow);
		if(Countrow.equals("0")){
			return true;
		}else {
			return false;
		}
		}
	
	
	public boolean checkUser(String email,String pass) throws SQLException {
		String sql = "SELECT * FROM Usuario WHERE nome=? and senha=?";
		boolean st =false;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,email);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery();  
	        st = rs.next();
		}catch(Exception e) {
            e.printStackTrace();
        }   
		System.out.println(st);
        return st;


		}

	
	public void adicionaTarefa(Tarefas tarefa) throws SQLException {
		String sql = "INSERT INTO Tarefas" +
		"(nome_tarefa,conteudo,data,categoria,nome_usuario) values(?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,tarefa.getNomeTarefa());
		stmt.setString(2,tarefa.getConteudo());
		stmt.setDate(3, new java.sql.Date(
				tarefa.getData().getTimeInMillis()));
		stmt.setString(4,tarefa.getCategoria());
		stmt.setString(5,tarefa.getNome_usuario());

		stmt.execute();
		stmt.close();
		}
	
	public void altera(Tarefas tarefa) throws SQLException {
		String sql = "UPDATE Tarefas SET " +
		"nome_tarefa=?,conteudo=?,data=?,categoria=?,nome_usuario=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNomeTarefa());
		stmt.setString(2,tarefa.getConteudo());
		stmt.setDate(3, new java.sql.Date(
				tarefa.getData().getTimeInMillis()));
		stmt.setString(4,tarefa.getCategoria());
		stmt.setString(5,tarefa.getNome_usuario());
		stmt.setInt(6, tarefa.getId());
		stmt.execute();
		stmt.close();
		}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarefas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		}
	
	public void close() throws SQLException {
		connection.close();
		}

}
