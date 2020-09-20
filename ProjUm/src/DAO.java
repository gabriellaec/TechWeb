import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	
	public List<Tarefas> getListaTarefas() throws SQLException {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.
		prepareStatement("SELECT * FROM Tarefas");
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
	
	public void adiciona(Usuario pessoa) throws SQLException {
		String sql = "INSERT INTO Usuario" +
		"(nome,senha) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,pessoa.getNome());
		stmt.setString(2,pessoa.getSenha());
		
		stmt.execute();
		stmt.close();
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
