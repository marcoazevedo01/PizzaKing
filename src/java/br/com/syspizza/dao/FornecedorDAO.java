package br.com.syspizza.dao;

import br.com.syspizza.modelo.Fornecedor;
import br.com.syspizza.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class FornecedorDAO implements GenericDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public FornecedorDAO() {
        try {
            this.conn = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao Banco de Dados " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {

        Boolean retorno = true;

        try {
            Fornecedor fornecedor = (Fornecedor) object;
            PessoaDAO pessoaDao = new PessoaDAO();

            String sql = "insert into fornecedor (cnpj, idPessoa) values (?,?);";

            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setInt(2, pessoaDao.cadastrar(fornecedor));

            stmt.execute();

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao cadastrar fornecedorDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    @Override
    public List<Object> listar() throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            String sql = "select p.idpessoa, f.cnpj, p.nome, p.email, p.telefone from fornecedor f inner join pessoa p on f.idFornecedor = p.idPessoa";

            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdPessoa(rs.getInt("idpessoa"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));

                lista.add(fornecedor);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar fornecedorDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;

    }

    @Override
    public Object carregar(Integer id) throws Exception {
        Fornecedor fornecedor = new Fornecedor();

        try {
            String sql = "select p.idpessoa, p.nome, f.cnpj, p.email, p.telefone from fornecedor f inner join pessoa p on f.idfornecedor = p.idpessoa where p.idpessoa = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            fornecedor.setIdPessoa(rs.getInt("idpessoa"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setTelefone(rs.getString("telefone"));

        } catch (Exception e) {
            System.out.println("Erro ao carregar fornecedorDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return fornecedor;
    }

    @Override
    public Boolean alterar(Object object) throws Exception {

        Boolean retorno = true;

        try {
            Fornecedor fornecedor = (Fornecedor) object;

            String sql = "update fornecedor set cnpj = ? where idpessoa = ?";

            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setInt(2, fornecedor.getIdPessoa());

            stmt.execute();

            PessoaDAO dao = new PessoaDAO();
            dao.alterar(fornecedor);

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao alterar fornecedorDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    @Override
    public Boolean excluir(Integer id) throws Exception {

        Boolean retorno = true;

        try {
            String sql = "delete from fornecedor where idPessoa = ?";

            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

            PessoaDAO dao = new PessoaDAO();
            dao.excluir(id);

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao excluir pessoaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    public List<Object> listarPorNome(String pesquisa) throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            pesquisa = "%" + pesquisa + "%";
            pesquisa = pesquisa.toUpperCase();
            String sql = "select p.idpessoa, p.nome, f.cnpj, p.email, p.telefone from fornecedor f inner join pessoa p on f.idfornecedor = p.idpessoa where UPPER(nome) like ? order by nome;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdPessoa(rs.getInt("idpessoa"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));

                lista.add(fornecedor);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listarPorNome fornecedorDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;
    }

    public List<Object> listarPorCodigo(Integer pesquisa) throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            String sql = "select p.idpessoa, p.nome, f.cnpj, p.email, p.telefone from fornecedor f inner join pessoa p on f.idfornecedor = p.idpessoa where p.idpessoa = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pesquisa);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdPessoa(rs.getInt("idpessoa"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));

                lista.add(fornecedor);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listarPorCodigo fornecedorDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;
    }

}
