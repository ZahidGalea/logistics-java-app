package cl.duocuc.arqSoftware.evaluacion;

import cl.duocuc.arqSoftware.evaluacion.entities.*;
import cl.duocuc.arqSoftware.evaluacion.utils.CourierCreator;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date fecha_envio = new Date(System.currentTimeMillis());
        Integer costo_envio = 123;
        String direccion = "Carmen 390";
        String comuna = "Santiago";
        String nombre_apellido = "Zahid";
        String numero_telefono = "123123";
        String rut = "123123k";
        String region = "c";
        Integer peso = 12;
        String tamanio = "Grande";


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


        // Notificación al courier
        boolean notificado = courier.notificarCourier();

        // Resguardar en Log o notificar que no se pudo notificar al courier
        if (!notificado) {
            System.out.println("Error en notificación al courier:" + courier.getNombre_courier());
        }

        System.out.println("Fin");

    }

    public static void trackear_paquete(Integer id_paquete) {
        System.out.println("Trackear paquete");
    }
}
