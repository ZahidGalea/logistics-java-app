DROP TABLE Estado_Envio CASCADE CONSTRAINTS;
DROP TABLE Courier CASCADE CONSTRAINTS;
DROP TABLE Envio CASCADE CONSTRAINTS;
DROP TABLE Paquete CASCADE CONSTRAINTS;
DROP TABLE Cliente CASCADE CONSTRAINTS;

CREATE TABLE Estado_Envio
(
    fecha_estado DATE         NOT NULL,
    id_tracking  INTEGER      NOT NULL,
    estado       VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_tracking)
);

CREATE TABLE Courier
(
    nombre         VARCHAR(200) NOT NULL,
    costo_por_peso VARCHAR(200) NOT NULL,
    region_reparte VARCHAR(200) NOT NULL,
    PRIMARY KEY (nombre)
);

CREATE TABLE Envio
(
    id_envio       INTEGER      NOT NULL,
    fecha_envio    DATE         NOT NULL,
    costo_envio    INTEGER      NOT NULL,
    id_tracking    INTEGER      NOT NULL,
    courier_nombre VARCHAR(200) NOT NULL,
    id_paquete     INTEGER      NOT NULL,
    id_cliente     INTEGER      NOT NULL,
    PRIMARY KEY (id_envio)
);

CREATE TABLE Paquete
(
    id_paquete INTEGER      NOT NULL,
    peso       INTEGER      NOT NULL,
    tamanio    VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_paquete)
);

CREATE TABLE Cliente
(
    id_cliente INTEGER      NOT NULL,
    direccion  VARCHAR(200) NOT NULL,
    comuna     VARCHAR(200) NOT NULL,
    nombre     VARCHAR(200) NOT NULL,
    numero_tlf VARCHAR(200) NOT NULL,
    region     VARCHAR(200) NOT NULL,
    rut        VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_cliente)
);

ALTER TABLE Envio
    ADD FOREIGN KEY (courier_nombre) REFERENCES Courier (nombre);
ALTER TABLE Envio
    ADD FOREIGN KEY (id_paquete) REFERENCES Paquete (id_paquete);
ALTER TABLE Envio
    ADD FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente);
ALTER TABLE Envio
    ADD FOREIGN KEY (id_tracking) REFERENCES Estado_Envio (id_tracking);

INSERT INTO COURIER (NOMBRE, COSTO_POR_PESO, REGION_REPARTE)
values ('Blue', 1000, 'c');
INSERT INTO COURIER (NOMBRE, COSTO_POR_PESO, REGION_REPARTE)
values ('Starken', 1500, 'b');
INSERT INTO COURIER (NOMBRE, COSTO_POR_PESO, REGION_REPARTE)
values ('ChileExpress', 1200, 'a');