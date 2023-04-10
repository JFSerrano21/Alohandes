INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (1, 'Operador Hotelero 1', 1001, 2001, 3001, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (2, 'Operador Hotelero 2', 1002, 2002, 3002, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (3, 'Operador Hostal 1', 1003, 2003, 3003, 'hostal');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (4, 'Operador Hostal 2', 1004, 2004, 3004, 'hostal');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (5, 'Operador Aloha 1', 1005, 2005, 3005, 'aloha');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (6, 'Operador Aloha 2', 1006, 2006, 3006, 'aloha');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (7, 'Operador Hotelero 3', 1007, 2007, 3007, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (8, 'Operador Hotelero 4', 1008, 2008, 3008, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (9, 'Operador Hostal 3', 1009, 2009, 3009, 'hostal');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (10, 'Operador Hostal 4', 1010, 2010, 3010, 'hostal');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (11, 'Operador Aloha 3', 1011, 2011, 3011, 'aloha');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (12, 'Operador Aloha 4', 1012, 2012, 3012, 'aloha');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (13, 'Operador Hotelero 5', 1013, 2013, 3013, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (14, 'Operador Hotelero 6', 1014, 2014, 3014, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (15, 'Operador Hostal 5', 1015, 2015, 3015, 'hostal');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (16, 'Operador Hostal 6', 1016, 2016, 3016, 'hostal');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (17, 'Operador Aloha 5', 1017, 2017, 3017, 'aloha');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (18, 'Operador Aloha 6', 1018, 2018, 3018, 'aloha');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (19, 'Operador Hotelero 7', 1019, 2019, 3019, 'hotel');
INSERT INTO Operador (id, nombre, codigo_camara_comercio, registro_superintendencia, cedula, tipo) VALUES (20, 'Operador Hotelero 8', 1020, 2020, 3020, 'hotel');


INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, bano_privado) VALUES (1, 1, 'hotel', 50, 'Calle 1, Ciudad A', 1000, 150.00, 'Y', 'Y', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (2, 2, 'hotel', 30, 'Calle 2, Ciudad B', 800, 120.00, 'Y', 'Y', 'N', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (3, 3, 'hostal', 20, 'Calle 3, Ciudad A', 500, 80.00, 'Y', 'N', 'Y', 'Y', 'N');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (4, 4, 'hostal', 25, 'Calle 4, Ciudad B', 600, 90.00, 'Y', 'N', 'Y', 'Y', 'N');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (5, 5, 'aloha', 10, 'Calle 5, Ciudad A', 300, 60.00, 'N', 'N', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (6, 1, 'hotel', 45, 'Calle 6, Ciudad C', 950, 140.00, 'Y', 'Y', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (7, 2, 'hotel', 35, 'Calle 7, Ciudad D', 850, 130.00, 'Y', 'Y', 'N', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (8, 3, 'hostal', 15, 'Calle 8, Ciudad C', 450, 70.00, 'Y', 'N', 'Y', 'Y', 'N');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (9, 4, 'hostal', 22, 'Calle 9, Ciudad D', 550, 85.00, 'Y', 'Y', 'N', 'Y', 'Y', 'N');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (10, 5, 'aloha', 12, 'Calle 10, Ciudad C', 320, 65.00, 'N', 'N', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (11, 1, 'hotel', 40, 'Calle 11, Ciudad E', 900, 145.00, 'Y', 'Y', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (12, 2, 'hotel', 28, 'Calle 12, Ciudad F', 750, 110.00, 'Y', 'Y', 'N', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (13, 3, 'hostal', 18, 'Calle 13, Ciudad E', 480, 75.00, 'Y', 'N', 'Y', 'Y', 'N');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (14, 4, 'hostal', 24, 'Calle 14, Ciudad F', 580, 95.00, 'Y', 'N', 'Y', 'Y', 'N');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (15, 5, 'aloha', 8, 'Calle 15, Ciudad E', 280, 55.00, 'N', 'N', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (16, 1, 'hotel', 55, 'Calle 16, Ciudad G', 1050, 160.00, 'Y', 'Y', 'Y', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (17, 2, 'hotel', 32, 'Calle 17, Ciudad H', 780, 115.00, 'Y', 'Y', 'N', 'N', 'Y');

INSERT INTO Alojamiento (id, id_operador, tipo, capacidad, ubicacion, tamano, precio, internet, sala, cocina, compartida, banio_privado) VALUES (18, 3, 'hostal', 12, 'Calle 18, Ciudad G', 420, 65.00, 'Y', 'N', 'Y', 'Y', 'N');



INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (1, 'Juan', 'Pérez', 'juan.perez@email.com', 1234567890, 'estudiante');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (2, 'Ana', 'García', 'ana.garcia@email.com', 2345678901, 'egresado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (3, 'Luis', 'Rodríguez', 'luis.rodriguez@email.com', 3456789012, 'empleado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (4, 'María', 'Fernández', 'maria.fernandez@email.com', 4567890123, 'profesor');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (5, 'Pedro', 'González', 'pedro.gonzalez@email.com', 5678901234, 'padre de estudiante');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (6, 'Carmen', 'Martínez', 'carmen.martinez@email.com', 6789012345, 'profesor invitado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (7, 'Javier', 'López', 'javier.lopez@email.com', 7890123456, 'persona registrada');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (8, 'Teresa', 'Ruiz', 'teresa.ruiz@email.com', 8901234567, 'estudiante');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (9, 'José', 'Ortiz', 'jose.ortiz@email.com', 9012345678, 'egresado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (10, 'Laura', 'Silva', 'laura.silva@email.com', 1234509876, 'empleado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (11, 'Miguel', 'Ramírez', 'miguel.ramirez@email.com', 2345609871, 'profesor');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (12, 'Sofía', 'Castro', 'sofia.castro@email.com', 3456701982, 'padre de estudiante');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (13, 'Carlos', 'Vargas', 'carlos.vargas@email.com', 4567019823, 'profesor invitado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (14, 'Susana', 'Rojas', 'susana.rojas@email.com', 5670198234, 'persona registrada');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (16, 'Andrea', 'Mendoza', 'andrea.mendoza@email.com', 6781902345, 'estudiante');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (17, 'Sergio', 'Herrera', 'sergio.herrera@email.com', 7819023456, 'egresado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (18, 'Cristina', 'Navarro', 'cristina.navarro@email.com', 8190234567, 'empleado');
INSERT INTO Usuario (id, nombre, apellido, correo_electronico, telefono, tipo) VALUES (19, 'Ricardo', 'Aguilar', 'ricardo.aguilar@email.com', 1902345678, 'profesor');

INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (1, 'Propuesta 1', 'Esta es la descripción de la propuesta 1', 1);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (2, 'Propuesta 2', 'Esta es la descripción de la propuesta 2', 2);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (3, 'Propuesta 3', 'Esta es la descripción de la propuesta 3', 3);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (4, 'Propuesta 4', 'Esta es la descripción de la propuesta 4', 4);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (5, 'Propuesta 5', 'Esta es la descripción de la propuesta 5', 5);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (6, 'Propuesta 6', 'Esta es la descripción de la propuesta 6', 6);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (7, 'Propuesta 7', 'Esta es la descripción de la propuesta 7', 7);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (8, 'Propuesta 8', 'Esta es la descripción de la propuesta 8', 8);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (9, 'Propuesta 9', 'Esta es la descripción de la propuesta 9', 9);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (10, 'Propuesta 10', 'Esta es la descripción de la propuesta 10', 10);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (11, 'Propuesta 11', 'Esta es la descripción de la propuesta 11', 11);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (12, 'Propuesta 12', 'Esta es la descripción de la propuesta 12', 12);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (13, 'Propuesta 13', 'Esta es la descripción de la propuesta 13', 13);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (14, 'Propuesta 14', 'Esta es la descripción de la propuesta 14',14)
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (15, 'Propuesta 15', 'Esta es la descripción de la propuesta 15', 15);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (16, 'Propuesta 16', 'Esta es la descripción de la propuesta 16', 16);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (17, 'Propuesta 17', 'Esta es la descripción de la propuesta 17', 17);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (18, 'Propuesta 18', 'Esta es la descripción de la propuesta 18', 18);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (19, 'Propuesta 19', 'Esta es la descripción de la propuesta 19', 19);
INSERT INTO Propuesta (id, titulo, descripcion, alojamientoId) VALUES (20, 'Propuesta 20', 'Esta es la descripción de la propuesta 20', 20);

INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (1, 1, 1, '2022-01-01', '2022-01-05', 500);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (2, 2, 2, '2022-01-06', '2022-01-10', 600);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (3, 3, 3, '2022-01-11', '2022-01-15', 450);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (4, 4, 4, '2022-01-16', '2022-01-20', 550);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (5, 5, 5, '2022-01-21', '2022-01-25', 650);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (6, 6, 6, '2022-01-26', '2022-01-30', 700);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (7, 7, 7, '2022-02-01', '2022-02-05', 520);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (8, 8, 8, '2022-02-06', '2022-02-10', 620);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (9, 9, 9, '2022-02-11', '2022-02-15', 470);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (10, 10, 10, '2022-02-16', '2022-02-20', 570);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (11, 11, 11, '2022-02-21', '2022-02-25', 670);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (12, 12, 12, '2022-02-26', '2022-03-02', 720);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (13, 13, 13, '2022-03-03', '2022-03-07', 540);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (14, 14, 14, '2022-03-08', '2022-03-12', 640);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (15, 15, 15, '2022-03-13', '2022-03-17', 490);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (16, 16, 16, '2022-03-18', '2022-03-22', 590);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (17, 17, 17, '2022-03-23', '2022-03-27', 690);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (18, 18, 18, '2022-03-28', '2022-04-01', 740);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (19, 19, 19, '2022-04-02', '2022-04-06', 560);
INSERT INTO Reserva (id, userId, alojamientoId, fechaInicial, fechaFinal, costo) VALUES (20, 20, 20, '2022-04-07', '2022-04-11', 660);

INSERT INTO Servicios (id, nombreServicio) VALUES (1, 'Piscina');
INSERT INTO Servicios (id, nombreServicio) VALUES (1, 'Gimnasio');
INSERT INTO Servicios (id, nombreServicio) VALUES (2, 'Estacionamiento');
INSERT INTO Servicios (id, nombreServicio) VALUES (2, 'Wi-Fi gratuito');
INSERT INTO Servicios (id, nombreServicio) VALUES (3, 'Desayuno incluido');
INSERT INTO Servicios (id, nombreServicio) VALUES (3, 'Recepción 24 horas');
INSERT INTO Servicios (id, nombreServicio) VALUES (4, 'Lavandería');
INSERT INTO Servicios (id, nombreServicio) VALUES (4, 'Aire acondicionado');
INSERT INTO Servicios (id, nombreServicio) VALUES (5, 'TV por cable');
INSERT INTO Servicios (id, nombreServicio) VALUES (5, 'Caja fuerte');
INSERT INTO Servicios (id, nombreServicio) VALUES (6, 'Restaurante');
INSERT INTO Servicios (id, nombreServicio) VALUES (6, 'Bar');
INSERT INTO Servicios (id, nombreServicio) VALUES (7, 'Piscina');
INSERT INTO Servicios (id, nombreServicio) VALUES (8, 'Gimnasio');
INSERT INTO Servicios (id, nombreServicio) VALUES (9, 'Estacionamiento');
INSERT INTO Servicios (id, nombreServicio) VALUES (10, 'Wi-Fi gratuito');
INSERT INTO Servicios (id, nombreServicio) VALUES (11, 'Desayuno incluido');
INSERT INTO Servicios (id, nombreServicio) VALUES (12, 'Recepción 24 horas');
INSERT INTO Servicios (id, nombreServicio) VALUES (13, 'Lavandería');
INSERT INTO Servicios (id, nombreServicio) VALUES (14, 'Aire acondicionado');
