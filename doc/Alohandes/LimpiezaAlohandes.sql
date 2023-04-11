-- Drop foreign key constraints:
ALTER TABLE Alojamiento DROP CONSTRAINT fk_operador_alojamiento;
ALTER TABLE Reserva DROP CONSTRAINT fk_reserva_usuario;
ALTER TABLE Reserva DROP CONSTRAINT fk_reserva_alojamiento;
ALTER TABLE Propuesta DROP CONSTRAINT fk_propuesta_alojamiento;

-- Drop the sequence:
DROP SEQUENCE alohandes_sequence;

-- Drop tables:
DROP TABLE Servicio CASCADE CONSTRAINTS;
DROP TABLE Reserva CASCADE CONSTRAINTS;
DROP TABLE Propuesta CASCADE CONSTRAINTS;
DROP TABLE Usuario CASCADE CONSTRAINTS;
DROP TABLE Alojamiento CASCADE CONSTRAINTS;
DROP TABLE Operador CASCADE CONSTRAINTS;

COMMIT;
