-- Eliminar tablas si existen
DROP TABLE IF EXISTS Estado_Pedido CASCADE;
DROP TABLE IF EXISTS Pedido CASCADE;
DROP TABLE IF EXISTS Sucursal CASCADE;
DROP TABLE IF EXISTS Mensajero CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;
DROP TABLE IF EXISTS Usuario CASCADE;

-- Crear tabla Usuario
CREATE TABLE Usuario (
    id_usuario SERIAL PRIMARY KEY,
    login VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- Crear tabla Cliente
CREATE TABLE Cliente (
    id_usuario INT PRIMARY KEY,
    email_cliente VARCHAR(255) UNIQUE NOT NULL,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    ciudad VARCHAR(255),
    telefono VARCHAR(20),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- Crear tabla Mensajero
CREATE TABLE Mensajero (
    id_usuario INT PRIMARY KEY,
    email_mensajero VARCHAR(255) UNIQUE NOT NULL,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- Crear tabla Sucursal
CREATE TABLE Sucursal (
    id_sucursal SERIAL PRIMARY KEY,
    nombre VARCHAR(255) UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_usuario)
);

-- Crear tabla Pedido
CREATE TABLE Pedido (
    codigo_pedido SERIAL PRIMARY KEY,
    fecha_hora_solicitud TIMESTAMP,
    origen VARCHAR(255),
    destino VARCHAR(255),
    ciudad VARCHAR(255),
    descripcion TEXT,
    tipo_transporte VARCHAR(50),
    num_paquetes INT,
    id_usuario INT,
    id_mensajero INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_mensajero) REFERENCES Mensajero(id_usuario)
);

-- Crear tabla Estado_Pedido
CREATE TABLE Estado_Pedido (
    id_estado SERIAL PRIMARY KEY,
    estado VARCHAR(50),
    fecha_hora_estado TIMESTAMP,
    foto BYTEA,
    codigo_pedido INT,
    FOREIGN KEY (codigo_pedido) REFERENCES Pedido(codigo_pedido)
);

-- Inserciones de ejemplo
-- Primero, los usuarios
INSERT INTO Usuario (login, contrasena) VALUES 
('usuario1', 'pass123'), 
('usuario2', 'pass456'),
('usuario3', 'pass789'),
('usuario4', 'pass101112');

-- Después, los clientes y mensajeros
INSERT INTO Cliente (id_usuario, email_cliente, nombre, direccion, ciudad, telefono)
VALUES (1, 'juan.perez@example.com', 'Juan Perez', 'Calle Falsa 123', 'Ciudad A', '123456789'),
       (2, 'maria.garcia@example.com', 'Maria Garcia', 'Avenida Siempre Viva 456', 'Ciudad B', '987654321');

INSERT INTO Mensajero (id_usuario, email_mensajero, nombre, direccion, telefono)
VALUES (3, 'carlos.mensajero@example.com', 'Carlos Mensajero', 'Avenida Los Angeles 789', '111222333'),
       (4, 'ana.mensajera@example.com', 'Ana Mensajera', 'Boulevard de la Paz 321', '444555666');

-- Finalmente, las sucursales, pedidos y estados de pedidos
INSERT INTO Sucursal (nombre, direccion, telefono, id_cliente)
VALUES ('Sucursal 1', 'Plaza Central 1', '555123456', 1),
       ('Sucursal 2', 'Calle Principal 2', '555654321', 2);

INSERT INTO Pedido (fecha_hora_solicitud, origen, destino, ciudad, descripcion, tipo_transporte, num_paquetes, id_usuario, id_mensajero)
VALUES ('2024-05-26 10:00:00', 'Sucursal 1', 'Cliente 1', 'Ciudad A', 'Documentos importantes', 'Moto', 1, 1, 3),
       ('2024-05-26 11:00:00', 'Sucursal 2', 'Cliente 2', 'Ciudad B', 'Paquete grande', 'Camioneta',3, 2, 4);

INSERT INTO Estado_Pedido (estado, fecha_hora_estado, codigo_pedido)
VALUES ('En camino', '2024-05-26 10:30:00', 1),
       ('Entregado', '2024-05-26 12:00:00', 1),
       ('En camino', '2024-05-26 11:30:00', 2),
       ('Entregado', '2024-05-26 13:00:00', 2);

SELECT * FROM usuario NATURAL JOIN cliente;
