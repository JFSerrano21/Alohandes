-- Eliminar restricciones y secuencias:

ALTER TABLE Alojamiento
DROP CONSTRAINT fk_alojamiento_operador;

ALTER TABLE Reserva
DROP CONSTRAINT fk_user,
DROP CONSTRAINT fk_alojamiento;

ALTER TABLE Propuesta
DROP CONSTRAINT fk_alojamiento;

ALTER TABLE Alojamiento
DROP CONSTRAINT fk_operador_alojamiento;

DROP SEQUENCE alohandes_sequence;

-- Eliminar tablas:

DROP TABLE Servicios;

DROP TABLE Reserva;

DROP TABLE Propuesta;

DROP TABLE Usuario;

DROP TABLE Alojamiento;

DROP TABLE Operador;

COMMIT;


