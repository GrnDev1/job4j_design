CREATE TABLE messenger(
id SERIAL PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE humans(
id SERIAL PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE messenger_humans(
id SERIAL PRIMARY KEY,
human_id INT REFERENCES humans(id),
messenger_id INT REFERENCES messenger(id)
);

INSERT INTO messenger(name)
VALUES('VK'), ('Instagram'), ('Facebook');

INSERT INTO humans(name)
VALUES ('Ivan'), ('Petr'), ('Roman');

INSERT INTO messenger_humans(human_id, messenger_id)
VALUES (1,1), (1,2), (1,3), (2,3), (3,2), (3,3);

SELECT *
FROM messenger;

SELECT *
FROM humans;

SELECT *
FROM messenger_humans;