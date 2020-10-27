package br.com.syspizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
    
    public static Connection conectar() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectou!");
            return DriverManager.getConnection(
             "jdbc:postgresql://localhost:5432/SysPizza","postgres","2603");              
        }catch(Exception ex){
           throw new Exception("Erro ao conectar"
                + ex.getMessage());
        }
    }
    
    public static void fecharConexao(
        Connection conn, Statement stmt, 
            ResultSet rs) throws Exception{
        try{
            if(rs != null){ 
                rs.close(); 
            }
            if(stmt != null) { 
                stmt.close(); 
            }
            if(conn != null) { 
                conn.close(); 
            }
        }catch(Exception ex){
            throw new Exception(
            "Erro ao fechar conexao" 
                    + ex.getMessage());
        }
    }
    
}
