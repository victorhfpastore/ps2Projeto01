package icaroevictor.persistencia;

import icaroevictor.entidades.ContaBancaria;
import java.sql.*;
import java.util.*;

public class ContaBancariaDaoMySql implements ContaBancariaDao{
    private String createSql = "INSERT INTO ContaBancaria VALUES (?, ?, ?, ?)";
    private String readSql = "SELECT * FROM ContaBancaria";
    private String updateSql = "UPDATE ContaBancaria SET nome_titular=?, saldo=? , nro_agencia=? WHERE id=?";
    private String deleteSql = "DELETE FROM ContaBancaria WHERE id=?";

    private final MySqlConnection mysql = new MySqlConnection();



    @Override
    public boolean create(ContaBancaria conta) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSql);

            stm.setInt(1, conta.getId());
            stm.setString(2, conta.getNome());
            stm.setLong(3, conta.getSaldo());
            stm.setInt(4, conta.getAgencia());

            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;
        }
        catch (final SQLException ex) {
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
    public List<ContaBancaria> read() {
        Connection conexao = mysql.getConnection();
        List<ContaBancaria> conta = new ArrayList();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                ContaBancaria contas = new ContaBancaria();
                contas.setId(rs.getInt("id"));
                contas.setNome(rs.getString("nome_titular"));
                contas.setSaldo(rs.getLong("saldo"));
                contas.setAgencia(rs.getInt("nro_agencia"));
                conta.add(contas);
            }

            return conta;

        }catch (final SQLException ex) {
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
        return conta;
    }



    @Override
    public boolean update(ContaBancaria conta) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSql);

            stm.setString(1, conta.getNome());
            stm.setLong(2, conta.getSaldo());
            stm.setInt(3, conta.getAgencia());
            stm.setInt(4, conta.getId());

            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;

        }catch (final SQLException ex) {
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
    public boolean delete(ContaBancaria conta) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSql);
            stm.setInt(1, conta.getId());
            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;

        }catch (final SQLException ex) {
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

