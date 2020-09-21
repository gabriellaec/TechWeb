import java.util.Calendar;
import java.sql.Date;

public class Tarefas {
	private Integer id;
	private String nome_tarefa;
	private Calendar data;
	private String conteudo;
	private String categoria;
	private String nome_usuario;

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNomeTarefa() {return this.nome_tarefa;}
	public void setNomeTarefa(String nome_tarefa) {this.nome_tarefa = nome_tarefa;}
	
	public Calendar getData() {return this.data;}
	public void setData(Calendar data2) {this.data = data2;}
	
	public String getConteudo() {return this.conteudo;}
	public void setConteudo(String conteudo) {this.conteudo = conteudo;}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

}
