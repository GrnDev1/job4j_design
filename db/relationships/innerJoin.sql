CREATE TABLE genre(
id SERIAL PRIMARY KEY,
name VARCHAR(125)
);

CREATE TABLE film(
id SERIAL PRIMARY KEY,
name VARCHAR(125),
genre_id INT REFERENCES genre(id)
);

INSERT INTO genre(name)
VALUES
('Action'), ('Adventure');

INSERT INTO film(name, genre_id)
VALUES
('Avatar', 1), ('The Mummy', 2);

SELECT f.id, f.name, g.name
FROM film AS f
INNER JOIN genre AS g
ON g.id = f.genre_id;

SELECT f.id AS Номер, f.name AS Название, g.name AS Жанр
FROM film AS f
INNER JOIN genre AS g
ON g.id = f.genre_id;

SELECT f.id Номер, f.name Название, g.name Жанр
FROM film AS f
JOIN genre AS g
ON g.id = f.genre_id;