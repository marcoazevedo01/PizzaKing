package br.com.syspizza.dao;

import br.com.syspizza.modelo.Bebida;
import br.com.syspizza.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAO implements GenericDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public BebidaDAO() {
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
            Bebida bebida = (Bebida) object;
            ProdutoDAO produtoDao = new ProdutoDAO();

            String sql = "insert into bebida (tipo, idProduto) values (?,?);";

            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, bebida.getTipo());
            stmt.setInt(2, produtoDao.cadastrar(bebida));

            stmt.execute();

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao cadastrar bebidaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    @Override
    public List<Object> listar() throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            String sql = "select p.idproduto, b.tipo, p.descricao, p.datavalidade, "
                    + "p.medida, p.valor from bebida b "
                    + "inner join produto p on b.idproduto = p.idproduto";

            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Bebida bebida = new Bebida();

                bebida.setIdProduto(rs.getInt("idproduto"));
                bebida.setTipo(rs.getString("tipo"));
                bebida.setDescricao(rs.getString("descricao"));
                bebida.setDataValidade(rs.getDate("datavalidade"));
                bebida.setMedida(rs.getDouble("medida"));
                bebida.setValor(rs.getDouble("valor"));

                lista.add(bebida);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar bebidaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;

    }

    @Override
    public Object carregar(Integer id) throws Exception {
        Bebida bebida = new Bebida();

        try {
            String sql = "select p.idproduto, b.tipo, p.descricao, p.datavalidade, "
                    + "p.medida, p.valor from bebida b "
                    + "inner join produto p on b.idproduto = p.idproduto "
                    + "where p.idproduto = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();

            bebida.setIdProduto(rs.getInt("idproduto"));
            bebida.setDescricao(rs.getString("descricao"));
            bebida.setTipo(rs.getString("tipo"));
            bebida.setDataValidade(rs.getDate("datavalidade"));
            bebida.setMedida(rs.getDouble("medida"));
            bebida.setValor(rs.getDouble("valor"));

        } catch (Exception e) {
            System.out.println("Erro ao carregar bebidaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return bebida;
    }

    @Override
    public Boolean alterar(Object object) throws Exception {

        Boolean retorno = true;

        try {
            Bebida bebida = (Bebida) object;

            String sql = "update bebida set tipo = ? where idproduto = ?";

            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, bebida.getTipo());
            stmt.setInt(2, bebida.getIdProduto());

            stmt.execute();

            ProdutoDAO dao = new ProdutoDAO();
            dao.alterar(bebida);

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao alterar bebidaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return retorno;
    }

    @Override
    public Boolean excluir(Integer id) throws Exception {

        Boolean retorno = true;

        try {
            String sql = "delete from bebida where idProduto = ?";

            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

            ProdutoDAO dao = new ProdutoDAO();
            dao.excluir(id);

        } catch (Exception e) {
            retorno = false;
            System.out.println("Erro ao excluir bebidaDAO " + e.getMessage());
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
            String sql = "select p.idproduto, b.tipo, p.descricao, p.datavalidade, "
                    + "p.medida, p.valor from bebida b "
                    + "inner join produto p on b.idproduto = p.idproduto "
                    + "where UPPER(p.descricao) like ? order by p.descricao;";
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Bebida bebida = new Bebida();

                bebida.setIdProduto(rs.getInt("idproduto"));
                bebida.setDescricao(rs.getString("descricao"));
                bebida.setTipo(rs.getString("tipo"));
                bebida.setDataValidade(rs.getDate("datavalidade"));
                bebida.setMedida(rs.getDouble("medida"));
                bebida.setValor(rs.getDouble("valor"));

                lista.add(bebida);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listarPorNome bebidaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;
    }

    public List<Object> listarPorCodigo(Integer pesquisa) throws Exception {

        List<Object> lista = new ArrayList<>();

        try {
            String sql = "select p.idproduto, b.tipo, p.descricao, p.datavalidade, "
                    + "p.medida, p.valor from bebida b "
                    + "inner join produto p on b.idproduto = p.idproduto "
                    + "where p.idproduto = ?";
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, pesquisa);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Bebida bebida = new Bebida();

                bebida.setIdProduto(rs.getInt("idproduto"));
                bebida.setDescricao(rs.getString("descricao"));
                bebida.setTipo(rs.getString("tipo"));
                bebida.setDataValidade(rs.getDate("datavalidade"));
                bebida.setMedida(rs.getDouble("medida"));
                bebida.setValor(rs.getDouble("valor"));

                lista.add(bebida);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listarPorCodigo bebidaDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        return lista;
    }

}
