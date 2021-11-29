package cl.duocuc.arqSoftware.evaluacion.dao;

import cl.duocuc.arqSoftware.evaluacion.entities.EstadoEnvio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class EstadoEnvioDAO {

    public boolean addEstadoEnvio(Connection conn, EstadoEnvio estadoEnvio) {
        PreparedStatement pst;
        String sql = "INSERT INTO ESTADO_ENVIO (FECHA_ESTADO, ID_TRACKING, ESTADO)" +
                "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setDate(1, new Date(estadoEnvio.getFecha_estado().getTime()));
            pst.setInt(2, estadoEnvio.getId_tracking());
            pst.setString(3, estadoEnvio.getEstado());
            pst.execute();
            pst.closeOnCompletion();
            System.out.println("Información guardada correctamente");

        } catch (Exception e) {
            System.out.println("EstadoEnvioDAO.addEstadoEnvio");
            System.out.println("Algo fallo:" + e.getMessage());
            return false;
        }
        return true;

    }

    public String modificarEstadoEnvio(Connection conn, EstadoEnvio estadoEnvio) {
        return null;
    }

}
