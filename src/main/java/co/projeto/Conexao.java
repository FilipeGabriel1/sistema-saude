package co.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_saude";
    
    private static final String usuario = "root";
   
    private static final String senha = "LightMobile123";
   
    public static Connection obterConexao() {
        try {
            return DriverManager.getConnection(URL, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter conexão com o banco de dados", e);
        }
    }
    
}