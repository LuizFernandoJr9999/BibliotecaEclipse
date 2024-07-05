package biblioteca.model;

import java.util.ArrayList;

public class Usuario {
	private Integer usuario_codigo; 
	private String usuario_nome;
	private String usuario_cpf; 
	private String usuario_email;  
	private ArrayList<Livro> livros = new ArrayList<Livro>();
}
