package cl.duocuc.arqSoftware.evaluacion.dao;

import cl.duocuc.arqSoftware.evaluacion.entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {


    public boolean addCliente(Connection conn, Cliente cliente) {
        PreparedStatement pst;
        String sql = "INSERT INTO CLIENTE (ID_CLIENTE, DIRECCION, COMUNA, NOMBRE, NUMERO_TLF, REGION, RUT)" +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cliente.getId_cliente());
            pst.setString(2, cliente.getDireccion());
            pst.setString(3, cliente.getComuna());
            pst.setString(4, cliente.getNombre_apellido());
            pst.setString(5, cliente.getNumero_telefono());
            pst.setString(6, cliente.getRegion());
            pst.setString(7, cliente.getRut());
            pst.execute();
            pst.closeOnCompletion();
            System.out.println("Información guardada correctamente");

        } catch (Exception e) {
            System.out.println("ClienteDAO.addCliente");
            System.out.println("Algo fallo:" + e.getMessage());
            return false;
        }
        return true;
    }

}
