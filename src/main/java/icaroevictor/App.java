package icaroevictor;

import icaroevictor.persistencia.ContaBancariaDaoMySql;
import icaroevictor.persistencia.PaisDaoMySql;

import java.sql.*;

public class App
{
    public static void main( String[] args ) {
        ContaBancariaDaoMySql mysqlDAO = new ContaBancariaDaoMySql();
        PaisDaoMySql mysqlDAO2 = new PaisDaoMySql();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO2, mysqlDAO);
        interfaceUsuario.imprimeboasvindas();
        interfaceUsuario.iniciar();
    }
}
