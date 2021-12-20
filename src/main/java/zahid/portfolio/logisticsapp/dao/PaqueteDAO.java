package zahid.portfolio.logisticsapp.dao;

import zahid.portfolio.logisticsapp.db_entities.Paquete;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class PaqueteDAO {

    public boolean addPaquete(Connection conn, Paquete paquete) {
        PreparedStatement pst;
        String sql = "INSERT INTO PAQUETE (ID_PAQUETE, PESO, TAMANIO)" +
                "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, paquete.getId_paquete());
            pst.setInt(2, paquete.getPeso());
            pst.setString(3, paquete.getTamanio());

            pst.execute();
            pst.closeOnCompletion();

            System.out.println("Paquete guardado correctamente");

        } catch (Exception e) {
            System.out.println("PaqueteDAO.addPaquete");
            System.out.println("Algo fallo:" + e.getMessage());
            return false;
        }
        return true;

    }
}
