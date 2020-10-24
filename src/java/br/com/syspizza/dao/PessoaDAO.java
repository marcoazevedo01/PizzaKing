package br.com.syspizza.dao;

import br.com.syspizza.modelo.Pessoa;
import br.com.syspizza.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author vitor
 */
public class PessoaDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public PessoaDAO() {
        try {
            this.conn = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao Banco de dados " + e.getMessage());
        }
    }

    public Integer cadastrar(Object object) throws Exception {

        Integer idPessoa = 0;

        try {
            Pessoa pessoa = (Pessoa) object;

            String sql = "insert into pessoa (nome, email, telefone) "
                    + "values (?,?,?) returning idPessoa;";

            stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getTelefone());

            rs = stmt.executeQuery();

            rs.next();

            idPessoa = rs.getInt("idPessoa");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }

        return idPessoa;

    }

    public void excluir(Integer id) throws Exception {

        try {
            String sql = "delete from pessoa where idPessoa = ?";
            
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir pessoaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
    }
    
    public void alterar(Object object) throws Exception{
        
        try{
            
           Pessoa pessoa = (Pessoa) object;
           
           String sql = "update pessoa set nome = ?, email = ?, telefone = ? where idpessoa = ?";
           
           stmt = this.conn.prepareStatement(sql);
           stmt.setString(1, pessoa.getNome());
           stmt.setString(2, pessoa.getEmail());
           stmt.setString(3, pessoa.getTelefone());
           stmt.setInt(4, pessoa.getIdPessoa());
           
           stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro ao alterar pessoaDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
    }
}
