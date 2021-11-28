package cl.duocuc.arqSoftware.evaluacion;

public class Cliente {

    private Integer id_cliente;
    private String direccion;
    private String comuna;
    private String region;
    private String nombre_apellido;
    private String rut;
    private String numero_telefono;

    public Cliente(String direccion, String comuna, String region, String nombre_apellido, String rut, String numero_telefono) {
        this.id_cliente = generarIdClient();
        this.direccion = direccion;
        this.comuna = comuna;
        this.region = region;
        this.nombre_apellido = nombre_apellido;
        this.rut = rut;
        this.numero_telefono = numero_telefono;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombre_appelido() {
        return nombre_apellido;
    }

    public void setNombre_appelido(String nombre_appelido) {
        this.nombre_apellido = nombre_appelido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public Integer generarIdClient() {
        return 1;
    }
}
