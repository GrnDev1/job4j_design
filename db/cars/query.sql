SELECT t1.id, t1.name car_name, t2.name body_name,
t3.name engine_name, t4.name transmission_name
FROM cars t1
LEFT JOIN car_bodies t2
ON t1.body_id = t2.id
LEFT JOIN car_engines t3
ON t1.engine_id = t3.id
LEFT JOIN car_transmissions t4
ON t1.transmission_id = t4.id

SELECT name body_name
FROM car_bodies
WHERE name NOT IN (
SELECT t2.name body_name
FROM cars t1
JOIN car_bodies t2
ON t1.body_id = t2.id)

SELECT name engine_name
FROM car_engines
WHERE name NOT IN (
SELECT t2.name
FROM cars t1
JOIN car_engines t2
ON t1.engine_id = t2.id)

SELECT name transmission_name
FROM car_transmissions
WHERE name NOT IN (
SELECT t2.name
FROM cars t1
JOIN car_transmissions t2
ON t1.transmission_id = t2.id)