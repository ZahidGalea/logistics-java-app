package cl.duocuc.arqSoftware.evaluacion;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date fecha_registro = new Date(System.currentTimeMillis());
        Integer costo_envio = 123;
        Date fecha_delivery = new Date(System.currentTimeMillis());
        String direccion = "Carmen 390";
        String comuna = "Santiago";
        String region = "c";
        String nombre_appelido = "Zahid";
        String rut = "123123k";
        String numero_telefono = "123123";
        Integer peso = 12;
        String tamanio = "Grande";


        registrar_paquete(fecha_registro, costo_envio, fecha_delivery, direccion, comuna, region, nombre_appelido, rut, numero_telefono, peso, tamanio);
    }


    public static void registrar_paquete(Date fecha_registro, Integer costo_envio, Date fecha_delivery, String direccion,
                                         String comuna, String region, String nombre_apellido,
                                         String rut, String numero_telefono, Integer peso, String tamanio) {

        System.out.println("Registrar paquete");
        Cliente cliente = new Cliente(direccion, comuna, region, nombre_apellido, rut, numero_telefono);
        Paquete paquete = new Paquete(peso, tamanio);
        Registro registro = new Registro(fecha_registro, costo_envio, fecha_delivery, cliente.getId_cliente(), paquete.getId_paquete());

        // Factory Pattern -
        CourierCreator courierCreator = new CourierCreator();
        Courier courier = courierCreator.createCourier(region);
        // Notificación al courier
        boolean notificado = courier.notificarCourier();

        // Resguardar en Log o notificar que no se pudo notificar al courier
        if (!notificado) {
            System.out.println("Notificando por error en notificación al courier:" + courier.getNombre_courier());
        }

        // Guardado en Base de datos
        registro.RegistrarBD();
    }

    public static void trackear_paquete(Integer id_paquete) {
        System.out.println("Trackear paquete");
        Tracker tracker = new Tracker(id_paquete);
    }
}
