package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	//private static String caminho = "jdbc:mysql://localhost/db_senhas" ;
	//private static String caminho = "jdbc:mysql://localhost/bibliotecagsmm" ;
	private static String caminho = "jdbc:mysql://localhost:3306/BibliotecaGSMM";
	private static String usuario = "root";
	private static String senha = "A@a@8988038A@a@8988038";
	
	
	//public static Connection faz_conexao() throws SQLException {
	public static Connection faz_conexao() {
				
		try {

			//Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("jdbc:mysql://");
			
			//return DriverManager.getConnection("jdbc:mysql://localhost/db_senhas","root","");
			return DriverManager.getConnection(caminho,usuario,senha);
					
		} catch (Exception e) {
			
			//throw new SQLException(e.getMessage());
	        System.out.println(e);
	        System.out.println("Couldnt get connection");
		}
		return null;		
	}
}
