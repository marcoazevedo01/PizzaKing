package br.com.syspizza.dao;

import br.com.syspizza.modelo.Produto;
import br.com.syspizza.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ProdutoDAO() {
        try {
            this.conn = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao Banco de dados " + e.getMessage());
        }
    }

    public Integer cadastrar(Object object) throws Exception {

        Integer idProduto = 0;

        try {
            Produto produto = (Produto) object;

            String sql = "insert into produto (descricao, dataValidade, medida, valor) "
                    + "values (?,?,?,?) returning idProduto;";

            stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, produto.getDescricao());
            stmt.setDate(2, new java.sql.Date(produto.getDataValidade().getTime()));
            stmt.setDouble(3, produto.getMedida());
            stmt.setDouble(4, produto.getValor());

            rs = stmt.executeQuery();

            rs.next();

            idProduto = rs.getInt("idProduto");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }

        return idProduto;

    }

    public void excluir(Integer id) throws Exception {

        try {
            String sql = "delete from produto where idProduto = ?";
            
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir produtoDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
    }
    
    public void alterar(Object object) throws Exception{
        
        try{
            
           Produto produto = (Produto) object;
           
           String sql = "update produto set descricao = ?, dataValidade = ?, "
                   + "medida = ?, valor = ? where idproduto = ?";
           
           stmt = this.conn.prepareStatement(sql);
           stmt.setString(1, produto.getDescricao());
           stmt.setDate(2, new java.sql.Date(produto.getDataValidade().getTime()));
           stmt.setDouble(3, produto.getMedida());
           stmt.setDouble(4, produto.getValor());
           stmt.setInt(5, produto.getIdProduto());
           
           stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro ao alterar produtoDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
    }

}
