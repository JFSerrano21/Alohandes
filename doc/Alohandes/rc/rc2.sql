SELECT a.id, a.tipo, COUNT(r.alojamientoId) as num_reservas
FROM Alojamiento a
JOIN Reserva r ON a.id = r.alojamientoId
GROUP BY a.id, a.tipo
ORDER BY COUNT(r.alojamientoId) DESC
FETCH NEXT 20 ROWS ONLY;