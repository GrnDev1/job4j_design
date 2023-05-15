CREATE TABLE car_bodies(
id SERIAL PRIMARY KEY,
name VARCHAR(125)
);

CREATE TABLE car_engines(
id SERIAL PRIMARY KEY,
name VARCHAR(125)
);

CREATE TABLE car_transmissions(
id SERIAL PRIMARY KEY,
name VARCHAR(125)
);

CREATE TABLE cars(
id SERIAL PRIMARY KEY,
name VARCHAR(125),
body_id INT REFERENCES car_bodies(id),
engine_id INT REFERENCES car_engines(id),
transmission_id INT REFERENCES car_transmissions(id)
);

INSERT INTO car_bodies(name)
VALUES
('Седан'),('Универсал'),
('Хэтчбэк'),('Купе'),
('Лимузин'),('Микроавтобус');

INSERT INTO car_engines(name)
VALUES
('Газовый двигатель'),('Дизельный двигатель'),
('Бензиновый двигатель'),('Карбюратор'),
('Инжектор');

INSERT INTO car_transmissions(name)
VALUES
('Механическая коробка'),('Автоматическая коробка'),
('Роботизированная коробка'),('Вариативная коробка');

INSERT INTO cars(name, body_id, engine_id, transmission_id)
VALUES
('Toyota Camry', 1, 3, 2),
('KIA SOUL', null, 2, 1),
('BMW 5', 1, 3, 2),
('Volkswagen Passat', 2, 2, 1);