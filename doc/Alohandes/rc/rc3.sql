SELECT p.id AS propuesta_id, a.id AS alojamiento_id,
       (SUM(r.fechaFinal - r.fechaInicial) / 365) * 100 AS indice_ocupacion
FROM Propuesta p
JOIN Alojamiento a ON p.alojamientoId = a.id
JOIN Reserva r ON a.id = r.alojamientoId
GROUP BY p.id, a.id
ORDER BY indice_ocupacion DESC;

