package zahid.portfolio.logisticsapp.api.bodies;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Venta {

    public Date fecha_envio;
    public int costo_envio;
    public String direccion;
    public String comuna;
    public String nombre_apellido;
    public String numero_telefono;
    public String rut;


    public Venta(@JsonProperty("fecha_envio") Date fecha_envio,
                 @JsonProperty("costo_envio") int costo_envio,
                 @JsonProperty("direccion") String direccion,
                 @JsonProperty("comuna") String comuna,
                 @JsonProperty("nombre_apellido") String nombre_apellido,
                 @JsonProperty("numero_telefono") String numero_telefono,
                 @JsonProperty("rut") String rut,
                 @JsonProperty("region") String region,
                 @JsonProperty("peso") int peso,
                 @JsonProperty("tamanio") String tamanio) {

        this.fecha_envio = fecha_envio;
        this.costo_envio = costo_envio;
        this.direccion = direccion;
        this.comuna = comuna;
        this.nombre_apellido = nombre_apellido;
        this.numero_telefono = numero_telefono;
        this.rut = rut;
        this.region = region;
        this.peso = peso;
        this.tamanio = tamanio;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public int getCosto_envio() {
        return costo_envio;
    }

    public void setCosto_envio(int costo_envio) {
        this.costo_envio = costo_envio;
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

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String region;
    public int peso;
    public String tamanio;


}
