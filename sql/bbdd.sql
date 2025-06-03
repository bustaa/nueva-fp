CREATE DATABASE IF NOT EXISTS portal_eventos;
USE portal_eventos;

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    fecha_registro DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS organizadores (
    id_organizador INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS categorias (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS ubicaciones (
    id_ubicacion INT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('online', 'presencial') NOT NUll,
    direccion VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS eventos (
    id_evento INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    fecha DATETIME NOT NULL,
    duracion TIME NOT NULL,
    id_ubicacion INT NOT NULL,
    id_organizador INT NOT NULL,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_ubicacion) REFERENCES ubicaciones(id_ubicacion),
    FOREIGN KEY (id_organizador) REFERENCES organizadores(id_organizador),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE IF NOT EXISTS inscripciones (
    id_inscripcion INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_evento INT NOT NULL,
    fecha_inscripcion DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_evento) REFERENCES eventos(id_evento)
)