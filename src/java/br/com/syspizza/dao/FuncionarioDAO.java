package br.com.syspizza.dao;

import br.com.syspizza.modelo.Funcionario;
import br.com.syspizza.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements GenericDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public FuncionarioDAO() {
        try {
            this.conn = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println(
                    "Erro ao conectar ao BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {

        Boolean retorno = true;

        try {
            String sql = "insert into funcionario "
                    + "(nome,salario,telefone) values (?,?,?);";

            Funcionario funcionario = (Funcionario) object;

            stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(2, funcionario.getSalario());
            stmt.setString(3, funcionario.getTelefone());

            stmt.execute();

        } catch (Exception e) {
            retorno = false;
            System.out.println(
                    "Erro ao cadastrar funcionarioDAO "
                    + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(
                    conn, stmt, rs);
        }

        return retorno;

    }

    @Override
    public List<Object> listar() throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            String sql = "select * from funcionario order by id;";
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setTelefone(rs.getString("telefone"));

                lista.add(funcionario);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar funcionarioDAO "
                    + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(
                    conn, stmt, rs);
        }
        return lista;
    }

    @Override
    public Object carregar(Integer id) throws Exception {

        Funcionario funcionario = new Funcionario();

        try {
            String sql = "select * from funcionario where id = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            rs.next();

            funcionario.setId(rs.getInt("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setSalario(rs.getDouble("salario"));
            funcionario.setTelefone(rs.getString("telefone"));

        } catch (Exception e) {
            System.out.println("Erro ao carregar funcionarioDAO "
                    + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return funcionario;
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        Boolean retorno = true;

        try {
            String sql = "update funcionario set nome = ?, "
                    + "salario = ?, telefone = ? where id = ?;";
            Funcionario funcionario = (Funcionario) object;
            stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setDouble(2, funcionario.getSalario());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setInt(4, funcionario.getId());

            stmt.execute();

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao alterar funcionarioCTR "
                    + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    @Override
    public Boolean excluir(Integer id) throws Exception {
        Boolean retorno = true;

        try {
            String sql = "delete from funcionario "
                    + "where id = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (Exception e) {
            retorno = false;
            System.out.println(
                    "Erro ao excluir funcionárioDAO "
                    + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    public List<Object> listarPorNome(String pesquisa) throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            pesquisa = "%"+pesquisa+"%";
            pesquisa = pesquisa.toUpperCase();
            String sql = "select * from funcionario where UPPER(nome) like ? order by nome;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setTelefone(rs.getString("telefone"));

                lista.add(funcionario);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listarPorNome funcionarioDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;
    }

    public List<Object> listarPorCodigo(Integer pesquisa) throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            String sql = "select * from funcionario where id = ?;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pesquisa);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setTelefone(rs.getString("telefone"));

                lista.add(funcionario);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listarPorCodigo funcionarioDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;
    }

}
