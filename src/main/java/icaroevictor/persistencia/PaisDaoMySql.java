package icaroevictor.persistencia;

import icaroevictor.entidades.Pais;
import java.sql.*;
import java.util.*;

public class PaisDaoMySql implements PaisDAO {
    private String createSQL = "INSERT INTO Pais VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM Pais";
    private String updateSQL = "UPDATE Pais SET nome=?, continente=?, populacao=? WHERE id=?";
    private String deleteSQL = "DELETE FROM Pais WHERE id=?";

    private final MySqlConnection mysql = new MySqlConnection();

    @Override
    public boolean create(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setInt(1, pais.getId());
            stm.setString(2, pais.getNome());
            stm.setString(3, pais.getContinente());
            stm.setLong(4, pais.getPopulacao());

            int registros = stm.executeUpdate();


            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Pais> read() {
        Connection conexao = mysql.getConnection();
        List<Pais> paises = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setNome(rs.getString("nome"));
                pais.setContinente(rs.getString("continente"));
                pais.setPopulacao(rs.getLong("populacao"));
                paises.add(pais);
            }

            return paises;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return paises;
    }

    @Override
    public boolean update(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);


            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getContinente());
            stm.setLong(3, pais.getPopulacao());

            int registros = stm.executeUpdate();


            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);


            stm.setString(1, pais.getNome());

            int registros = stm.executeUpdate();


            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}

