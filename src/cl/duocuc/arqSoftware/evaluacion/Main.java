package cl.duocuc.arqSoftware.evaluacion;

import cl.duocuc.arqSoftware.evaluacion.dao.ClienteDAO;
import cl.duocuc.arqSoftware.evaluacion.dao.EnvioDAO;
import cl.duocuc.arqSoftware.evaluacion.dao.EstadoEnvioDAO;
import cl.duocuc.arqSoftware.evaluacion.dao.PaqueteDAO;
import cl.duocuc.arqSoftware.evaluacion.db.Conexion;
import cl.duocuc.arqSoftware.evaluacion.entities.*;
import cl.duocuc.arqSoftware.evaluacion.utils.CourierCreator;

import java.sql.Connection;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date fecha_envio = new Date(System.currentTimeMillis());
        int costo_envio = 123;
        String direccion = "Carmen 390";
        String comuna = "Santiago";
        String nombre_apellido = "Zahid";
        String numero_telefono = "123123";
        String rut = "123123k";
        String region = "c";
        int peso = 12;
        String tamanio = "Grande";

        registrar_paquete(fecha_envio, costo_envio, direccion, comuna, region, nombre_apellido, rut, numero_telefono, peso, tamanio);

        fecha_envio = new Date(System.currentTimeMillis());
        costo_envio = 122;
        direccion = "Carmen 340";
        comuna = "Santiago";
        nombre_apellido = "Alejandro";
        numero_telefono = "123123";
        rut = "123123k";
        region = "b";
        peso = 10;
        tamanio = "Grande";

        registrar_paquete(fecha_envio, costo_envio, direccion, comuna, region, nombre_apellido, rut, numero_telefono, peso, tamanio);

    }


    public static void registrar_paquete(Date fecha_envio, Integer costo_envio, String direccion,
                                         String comuna, String region, String nombre_apellido,
                                         String rut, String numero_telefono, Integer peso, String tamanio) {

        System.out.println("Registrar paquete");
        Cliente cliente = new Cliente(direccion, comuna, region, nombre_apellido, rut, numero_telefono);
        Paquete paquete = new Paquete(peso, tamanio);
        EstadoEnvio estadoEnvio = new EstadoEnvio(fecha_envio, "Orden creada");

        // Factory Pattern -
        CourierCreator courierCreator = new CourierCreator();
        Courier courier = courierCreator.createCourier(region);

        Envio envio = new Envio(fecha_envio,
                costo_envio,
                paquete.getId_paquete(),
                cliente.getId_cliente(),
                estadoEnvio.getId_tracking(),
                courier.getNombre_courier()
        );


        // Notificación al courier, primero que tod0.
        boolean notificado = courier.notificarCourier();

        // Resguardar en Log o notificar que no se pudo notificar al courier
        if (!notificado) {
            System.out.println("Error en notificación al courier:" + courier.getNombre_courier());
            // TODO: Añadir proceso de alerta...
            // ...
        }

        // Genero la conexión
        Conexion conexion = new Conexion();
        Connection conn = Conexion.getConnection();

        // Guardo los datos

        // Genero los DAO
        ClienteDAO clienteDAO = new ClienteDAO();
        EnvioDAO envioDAO = new EnvioDAO();
        EstadoEnvioDAO estadoEnvioDAO = new EstadoEnvioDAO();
        PaqueteDAO paqueteDAO = new PaqueteDAO();

        // Guardo los datos.
        paqueteDAO.addPaquete(conn, paquete);
        clienteDAO.addCliente(conn, cliente);
        estadoEnvioDAO.addEstadoEnvio(conn, estadoEnvio);
        envioDAO.addEnvio(conn, envio);

        // Me desconecto
        conexion.desconexion(conn);
        System.out.println("Fin");

    }

    public static void trackear_paquete(Integer id_paquete) {
        System.out.println("Trackear paquete");
    }
}
