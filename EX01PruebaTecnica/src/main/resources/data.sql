DROP table IF EXISTS usuario;
DROP table IF EXISTS perfil_usuario;
DROP table IF EXISTS videojuego;
DROP table IF EXISTS partida;
DROP table IF EXISTS jugador;

CREATE TABLE usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre_usuario VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE perfil_usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre_jugador VARCHAR(255),
  usuario_id INT UNIQUE,
  CONSTRAINT perfilusu_fk FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE videojuego (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  genero VARCHAR(255)
);

CREATE TABLE partida (
  id INT AUTO_INCREMENT PRIMARY KEY,
  videojuego_id INT,
  CONSTRAINT partida_fk FOREIGN KEY (videojuego_id) REFERENCES videojuego(id)
);

CREATE TABLE miembro_partida (
  partida_id INT,
  usuario_id INT,
  PRIMARY KEY (partida_id, usuario_id),
  CONSTRAINT miempartida_fk1 FOREIGN KEY (partida_id) REFERENCES partida(id),
  CONSTRAINT miempartida_fk2 FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE mensaje (
  id INT AUTO_INCREMENT PRIMARY KEY,
  contenido VARCHAR(255),
  fecha_hora DATETIME,
  remitente_id INT,
  partida_id INT,
  CONSTRAINT mensaje_fk1 FOREIGN KEY (remitente_id) REFERENCES usuario(id),
  CONSTRAINT mensaje_fk2 FOREIGN KEY (partida_id) REFERENCES partida(id)
);

-- Insertar usuarios
INSERT INTO usuario (nombre_usuario, email, password) VALUES ('alberto', 'alberto@email.com', 'pass1');
INSERT INTO usuario (nombre_usuario, email, password) VALUES ('tamy', 'tamy@email.com', 'pass2');

-- Insertar perfiles de usuario
INSERT INTO perfil_usuario (nombre_jugador, usuario_id) VALUES ('alberto_jugador', 1);
INSERT INTO perfil_usuario (nombre_jugador, usuario_id) VALUES ('tamy_jugador', 2);

-- Insertar videojuegos
INSERT INTO videojuego (nombre, genero) VALUES ('Halo', 'FPS');
INSERT INTO videojuego (nombre, genero) VALUES ('FIFA', 'Deportes');

-- Insertar partidas
INSERT INTO partida (videojuego_id) VALUES (1);
INSERT INTO partida (videojuego_id) VALUES (2);

-- Insertar miembros en partidas
INSERT INTO miembro_partida (partida_id, usuario_id) VALUES (1, 1);
INSERT INTO miembro_partida (partida_id, usuario_id) VALUES (1, 2);
INSERT INTO miembro_partida (partida_id, usuario_id) VALUES (2, 1);

-- Insertar mensajes
INSERT INTO mensaje (contenido, fecha_hora, remitente_id, partida_id) VALUES ('Hola, jugamos?', NOW(), 1, 1);
INSERT INTO mensaje (contenido, fecha_hora, remitente_id, partida_id) VALUES ('cuando?', NOW(), 2, 1);
INSERT INTO mensaje (contenido, fecha_hora, remitente_id, partida_id) VALUES ('Jugamos al FIFA', NOW(), 1, 2);



