/*
A continuación, se deben realizar las siguientes consultas sobre la base de datos:
*/

/* 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente. */
SELECT *
FROM jugadores
ORDER BY Nombre;

/* 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras,
ordenados por nombre alfabéticamente. */
SELECT *
FROM jugadores
WHERE Posicion = 'C' AND Peso > 200
ORDER BY Nombre;

/* 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente. */
SELECT *
FROM equipos
ORDER BY Nombre;

/* 4. Mostrar el nombre de los equipos del este (East). */
SELECT *
FROM equipos
WHERE Conferencia = 'East'
ORDER BY Nombre;

/* 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre. */
SELECT *
FROM equipos
WHERE Ciudad LIKE 'c%'
ORDER BY Nombre;

/* 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo. */
SELECT *
FROM jugadores
ORDER BY Nombre_equipo;

/* 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre. */ 
SELECT *
FROM jugadores
WHERE Nombre_equipo = 'Raptors'
ORDER BY Nombre;

/* 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’. */
SELECT *
FROM estadisticas
WHERE jugador = (SELECT codigo FROM jugadores WHERE Nombre = 'Pau Gasol');


/* 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′. */
SELECT *
FROM estadisticas e
WHERE jugador = (SELECT codigo FROM jugadores WHERE Nombre = 'Pau Gasol')
  AND e.temporada = '04/05';

/* 10. Mostrar el número de puntos de cada jugador en toda su carrera. */
SELECT e.jugador, j.Nombre, ROUND(SUM(e.Puntos_por_partido), 2) AS Total_puntos
FROM estadisticas e
JOIN jugadores j ON j.codigo = e.jugador
GROUP BY e.jugador;

/* 11. Mostrar el número de jugadores de cada equipo. */
SELECT e.Nombre, COUNT(j.Nombre_equipo) AS Número_de_jugadores
FROM equipos e
JOIN jugadores j ON e.Nombre = j.Nombre_equipo
WHERE e.Nombre = j.Nombre_equipo
GROUP BY e.Nombre;

/* 12. Mostrar el jugador que más puntos ha realizado en toda su carrera. */
SELECT e.jugador, j.Nombre, ROUND(SUM(e.Puntos_por_partido), 2) AS Total_puntos
FROM estadisticas e
JOIN jugadores j ON j.codigo = e.jugador
GROUP BY e.jugador
ORDER BY Total_puntos DESC
LIMIT 1;

/* 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA. */
SELECT e.Nombre, e.Conferencia, e.Division, j.Nombre
FROM equipos e
JOIN jugadores j ON e.Nombre = j.Nombre_equipo
WHERE j.Altura = (SELECT MAX(Altura) FROM jugadores);

/* 14. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor
diferencia de puntos. */
SELECT equipo_local, equipo_visitante, ABS(puntos_local - puntos_visitante) AS Diferencia_de_puntos
FROM partidos
ORDER BY Diferencia_de_puntos DESC
LIMIT 4;

/* 15. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante,
equipo_ganador), en caso de empate sera null. */
SELECT codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante,
       CASE
           WHEN puntos_local > puntos_visitante THEN equipo_local
           WHEN puntos_local < puntos_visitante THEN equipo_visitante
           ELSE NULL
       END AS equipo_ganador
FROM partidos;

SELECT codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante, 
	IF(puntos_local > puntos_visitante, equipo_local, 
	IF(puntos_local < puntos_visitante, equipo_visitante, NULL))
    AS equipo_ganador
FROM partidos;