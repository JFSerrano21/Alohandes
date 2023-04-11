SELECT 
  Operador.id, 
  Operador.nombre, 
  SUM(Reserva.costo) AS Dinero_Recibido
FROM 
  Operador
  INNER JOIN Alojamiento ON Operador.id = Alojamiento.id_operador
  INNER JOIN Reserva ON Alojamiento.id = Reserva.alojamientoId
WHERE 
  Reserva.fechaInicial >= '2022-01-01' AND Reserva.fechaFinal <= '2022-12-31'
GROUP BY 
  Operador.id, Operador.nombre;