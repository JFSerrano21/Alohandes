CREATE SEQUENCE alohandes_sequence;

CREATE TABLE Operador (
  id INT PRIMARY KEY NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  codigo_camara_comercio INT,
  registro_superintendencia INT,
  cedula INT,
  tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('hotel', 'hostal', 'aloha'))
);

CREATE TABLE Alojamiento (
  id INT PRIMARY KEY NOT NULL,
  id_operador INT NOT NULL,
  tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('hotel', 'hostal', 'aloha', 'alojamiento')),
  capacidad INT NOT NULL,
  ubicacion VARCHAR(100),
  tamano INT,
  precio FLOAT,
  internet CHAR(1) CHECK (internet IN ('Y', 'N')),
  sala CHAR(1) CHECK (sala IN ('Y', 'N')),
  cocina CHAR(1) CHECK (cocina IN ('Y', 'N')),
  compartida CHAR(1) CHECK (compartida IN ('Y', 'N')),
  bano_privado CHAR(1) CHECK (bano_privado IN ('Y', 'N')),
  CONSTRAINT fk_operador_alojamiento FOREIGN KEY (id_operador)
    REFERENCES Operador(id)
);

CREATE TABLE Usuario (
  id INT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  correo_electronico VARCHAR(255) NOT NULL,
  telefono INT NOT NULL,
  tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('estudiante', 'egresado', 'empleado', 'profesor', 'padre de estudiante', 'profesor invitado', 'persona registrada'))
);

CREATE TABLE Propuesta (
  id INT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  alojamientoId INT NOT NULL,
  CONSTRAINT fk_propuesta_alojamiento FOREIGN KEY (alojamientoId)
    REFERENCES Alojamiento(id)
);

CREATE TABLE Reserva (
  id INT PRIMARY KEY,
  userId INT NOT NULL,
  alojamientoId INT NOT NULL,
  fechaInicial DATE NOT NULL,
  fechaFinal DATE NOT NULL,
  costo INT NOT NULL,
  CONSTRAINT fk_reserva_usuario FOREIGN KEY (userId)
    REFERENCES Usuario(id),
  CONSTRAINT fk_reserva_alojamiento FOREIGN KEY (alojamientoId)
    REFERENCES Alojamiento(id)
);

CREATE TABLE Servicio (
  id INT NOT NULL,
  nombreServicio VARCHAR(255) NOT NULL,
  PRIMARY KEY (id, nombreServicio),
  CONSTRAINT fk_servicios_alojamiento FOREIGN KEY (id)
    REFERENCES Alojamiento(id)
);

COMMIT;
