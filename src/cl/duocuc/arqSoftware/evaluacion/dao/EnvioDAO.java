package cl.duocuc.arqSoftware.evaluacion.dao;

import cl.duocuc.arqSoftware.evaluacion.entities.Envio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class EnvioDAO {

    public boolean addEnvio(Connection conn, Envio envio) {
        PreparedStatement pst;
        String sql = "INSERT INTO ENVIO (ID_ENVIO, FECHA_ENVIO, COSTO_ENVIO, ID_TRACKING, COURIER_NOMBRE, ID_PAQUETE, ID_CLIENTE)" +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, envio.getId_envio());
            pst.setDate(2, new Date(envio.getFecha_envio().getTime()));
            pst.setInt(3, envio.getCosto_envio());
            pst.setInt(4, envio.getId_tracking());
            pst.setString(5, envio.getCourier_nombre());
            pst.setInt(6, envio.getId_paquete());
            pst.setInt(7, envio.getId_cliente());
            pst.execute();
            pst.closeOnCompletion();
            System.out.println("Envio guardado correctamente");

        } catch (Exception e) {
            System.out.println("EnvioDAO.addEnvio");
            System.out.println("Algo fallo:" + e.getMessage());
            return false;
        }
        return true;
    }

}
