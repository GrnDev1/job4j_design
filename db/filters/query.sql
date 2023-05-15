SELECT *
FROM product
WHERE type_id = 1;

SELECT *
FROM product
WHERE LOWER (name) LIKE '%мороженое%';

SELECT *
FROM product
WHERE current_date > expired_date;

SELECT *
FROM product
WHERE price = (SELECT MAX(price) FROM product);

SELECT t.name Название, COUNT(p.name) Количество
FROM product p
JOIN type t
ON t.id = p.type_id
GROUP BY t.name;

SELECT *
FROM product
WHERE type_id IN (1, 2);

SELECT t.name Название, COUNT(p.name) Количество
FROM product p
JOIN type t
ON t.id = p.type_id
GROUP BY t.name
HAVING COUNT(p.name) < 10;

SELECT p.name Название, t.name
FROM product p
JOIN type t
ON t.id = p.type_id;