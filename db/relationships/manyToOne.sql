CREATE TABLE genre(
id SERIAL PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE film(
id SERIAL PRIMARY KEY,
name VARCHAR(255),
genre_id INT REFERENCES genre(id)
);

INSERT INTO genre(name)
VALUES ('Action'), ('Adventure');

INSERT INTO film (name, genre_id)
VALUES ('Avatar', 1), ('The Mummy', 2);

SELECT *
FROM film;

SELECT *
FROM genre
WHERE id IN (SELECT genre_id FROM film);

