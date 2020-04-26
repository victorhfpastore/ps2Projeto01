package icaroevictor.persistencia;


import java.sql.*;
public class MySqlConnection {
    String url = "jdbc:mysql://127.0.0.1:3306/projeton1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String usuario = "root";
    String senha = "";


    public Connection getConnection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

