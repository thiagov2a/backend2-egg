/*
CANDADO A
*/

/* Posición */
SELECT COUNT(*)
FROM estadisticas e
WHERE e.Asistencias_por_partido = (
	SELECT MAX(e.Asistencias_por_partido)
    FROM estadisticas e
);
-- Resultado: 2

/* Clave */
SELECT SUM(j.Peso)
FROM jugadores j
JOIN equipos e ON j.Nombre_equipo = e.Nombre
WHERE e.Conferencia = 'East'
  AND j.Posicion LIKE '%C%';
-- Resultado: 14043
  
/*
CANDADO B
*/

/* Posición */
SELECT COUNT(*)
FROM jugadores j
JOIN estadisticas e ON j.codigo = e.jugador
WHERE e.Asistencias_por_partido > (
    SELECT COUNT(*) 
    FROM jugadores j2
    WHERE j2.Nombre_equipo = 'Heat'
);
-- Resultado: 3

/* Clave */

-- Resultado:

/*
CANDADO C
*/

/* Posición */

-- Resultado:

/* Clave */

-- Resultado:

/*
CANDADO D
*/

/* Posición */

-- Resultado:

/* Clave */

-- Resultado: