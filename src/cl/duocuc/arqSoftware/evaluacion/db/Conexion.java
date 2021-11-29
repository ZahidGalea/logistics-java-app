package cl.duocuc.arqSoftware.evaluacion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conn = null;
    private static String login = "arq_application";
    private static String clave = "123123ajshkgdakjhsd";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Conexión errónea");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void desconexion(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión" + e.getMessage());
        }

    }


}
