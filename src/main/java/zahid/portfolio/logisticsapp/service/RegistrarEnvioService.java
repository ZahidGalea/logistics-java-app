package zahid.portfolio.logisticsapp.service;

import zahid.portfolio.logisticsapp.api.bodies.Venta;
import zahid.portfolio.logisticsapp.dao.*;
import zahid.portfolio.logisticsapp.db.Conexion;
import zahid.portfolio.logisticsapp.db_entities.*;
import zahid.portfolio.logisticsapp.utils.CourierCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class RegistrarEnvioService {
    private final ClienteDAO clienteDAO;
    private final CourierDAO courierDAO;
    private final EnvioDAO envioDAO;
    private final EstadoEnvioDAO estadoEnvioDAO;
    private final PaqueteDAO paqueteDAO;

    @Autowired
    public RegistrarEnvioService(@Qualifier("clienteDAO") ClienteDAO clienteDAO,
                                 @Qualifier("courierDAO") CourierDAO courierDAO,
                                 @Qualifier("envioDAO") EnvioDAO envioDAO,
                                 @Qualifier("estadoEnvioDAO") EstadoEnvioDAO estadoEnvioDAO,
                                 @Qualifier("paqueteDAO") PaqueteDAO paqueteDAO) {
        this.clienteDAO = clienteDAO;
        this.courierDAO = courierDAO;
        this.envioDAO = envioDAO;
        this.estadoEnvioDAO = estadoEnvioDAO;
        this.paqueteDAO = paqueteDAO;
    }


    public void registrarEnvio(Venta venta) {
        System.out.println("Registrar paquete");
        Cliente cliente = new Cliente(venta.direccion, venta.comuna, venta.region, venta.nombre_apellido, venta.rut, venta.numero_telefono);
        Paquete paquete = new Paquete(venta.peso, venta.tamanio);
        EstadoEnvio estadoEnvio = new EstadoEnvio(venta.fecha_envio, "Orden creada");

        // Factory Pattern -
        CourierCreator courierCreator = new CourierCreator();
        Courier courier = courierCreator.createCourier(venta.region);
        System.out.println(courier);

        Envio envio = new Envio(venta.fecha_envio,
                venta.costo_envio,
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

        // Guardo los datos.
        paqueteDAO.addPaquete(conn, paquete);
        clienteDAO.addCliente(conn, cliente);
        estadoEnvioDAO.addEstadoEnvio(conn, estadoEnvio);
        envioDAO.addEnvio(conn, envio);

        // Me desconecto
        conexion.desconexion(conn);
        System.out.println("Fin");
    }


}
