# Ecommerce - Logistics Project

----


En este proyecto se encuentra una pequeña app de logistica, el cual toma por parametros un objeto, y tiene los métodos
necesarios para notificar a un courier que pueda buscar un paquete.

Hecho con el objetivo de presentar en Arquitectura de Software.

Casos de uso involucrados:

* Registro de un paquete
* Notificación a un sistema interesado.

Aplicaciones:

* DAO
* Factory Pattern

Atributos de calidad fundamentales:

* Eficiencia de desempenio - Escalado horizontal
* Compatibilidad - Comunicacion mediante HTTPS

### Casos de uso:

![alt text](img/Casos%20de%20uso.drawio.png)

### Rutas API

* api/v1/registrar-venta
  * Ejemplo de Body esperado:
    * {
      "fecha_envio": "2021-12-10",
      "costo_envio": "123",
      "direccion": "Carmen 1231323",
      "comuna": "Santiago",
      "nombre_apellido": "Zahid Galea",
      "numero_telefono": "123123123",
      "rut": "123123123",
      "region": "c",
      "peso": 12,
      "tamanio": "grande"
      }