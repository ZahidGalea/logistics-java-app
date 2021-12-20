package zahid.portfolio.logisticsapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conn = null;
    private static final String login = "arq_application";
    private static final String clave = "123123ajshkgdakjhsd";
    private static final String url = "jdbc:oracle:thin:@//localhost:46643/XEPDB1";

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(true);
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
