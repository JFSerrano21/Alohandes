WITH alojamientos_disponibles AS (
  SELECT a.*
  FROM Alojamiento a
  WHERE NOT EXISTS (
    SELECT 1
    FROM Reserva r
    WHERE r.alojamientoId = a.id
      AND (r.fechaInicial BETWEEN TO_DATE('2023-05-01', 'YYYY-MM-DD') AND TO_DATE('2023-05-10', 'YYYY-MM-DD')
        OR r.fechaFinal BETWEEN TO_DATE('2023-05-01', 'YYYY-MM-DD') AND TO_DATE('2023-05-10', 'YYYY-MM-DD'))
  )
)
SELECT ad.*
FROM alojamientos_disponibles ad
WHERE ad.internet = 'Y' -- Reemplazar con los requerimientos deseados
  AND ad.sala = 'Y'
  AND ad.cocina = 'Y'
  AND ad.compartida = 'N'
  AND ad.bano_privado = 'Y'
ORDER BY ad.precio ASC;