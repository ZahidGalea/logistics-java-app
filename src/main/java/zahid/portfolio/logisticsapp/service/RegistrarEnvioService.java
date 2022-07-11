package zahid.portfolio.logisticsapp.service;

import zahid.portfolio.logisticsapp.api.bodies.Venta;
import zahid.portfolio.logisticsapp.dao.*;
import zahid.portfolio.logisticsapp.db_entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegistrarEnvioService {
    private final ClienteDAO clienteDAO;
    private final CourierDAO courierDAO;
    private final EnvioDAO envioDAO;
    private final EstadoEnvioDAO estadoEnvioDAO;
    private final PaqueteDAO paqueteDAO;
    private final CourierCreatorService courierCreatorService;

    @Autowired
    public RegistrarEnvioService(@Qualifier("postgresqlCliente") ClienteDAO clienteDAO,
                                 @Qualifier("postgresqlCourier") CourierDAO courierDAO,
                                 @Qualifier("postgresqlEnvio") EnvioDAO envioDAO,
                                 @Qualifier("postgresqlEstadoEnvio") EstadoEnvioDAO estadoEnvioDAO,
                                 @Qualifier("postgresqlPaquete") PaqueteDAO paqueteDAO,
                                 CourierCreatorService courierCreatorService) {
        this.clienteDAO = clienteDAO;
        this.courierDAO = courierDAO;
        this.envioDAO = envioDAO;
        this.estadoEnvioDAO = estadoEnvioDAO;
        this.paqueteDAO = paqueteDAO;
        this.courierCreatorService = courierCreatorService;
    }


    public void registrarEnvio(Venta venta) throws Exception {
        System.out.println("Registrar paquete");
        Cliente cliente = new Cliente(venta.direccion, venta.comuna, venta.region, venta.nombre_apellido, venta.rut, venta.numero_telefono);
        Paquete paquete = new Paquete(venta.peso, venta.tamanio);
        EstadoEnvio estadoEnvio = new EstadoEnvio(venta.fecha_envio, "Orden creada");

        // Factory Pattern -
        Courier courier = this.courierCreatorService.createCourier(venta.region);
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

        // Guardo los datos.
        paqueteDAO.addPaquete(paquete);
        clienteDAO.addCliente(cliente);
        estadoEnvioDAO.addEstadoEnvio(estadoEnvio);
        envioDAO.addEnvio(envio);

        System.out.println("Fin");
    }


}
