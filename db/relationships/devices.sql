create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

INSERT INTO devices(name, price)
VALUES
('Computer', 50000),
('Smartphone', 10000),
('Smartwatches', 4000);

INSERT INTO people(name)
VALUES
('Alex'), ('Roman'), ('Anna');

INSERT INTO devices_people(device_id, people_id)
VALUES
(1,1), (1,2),
(2,1), (2,2), (2,3),
(3,1), (3,3);

SELECT AVG(price) "Средняя цена"
FROM devices;

SELECT t2.name Имя, AVG(price) "Средняя цена"
FROM devices_people AS t1
JOIN people AS t2
ON t1.people_id = t2.id
JOIN devices AS t3
ON t1.device_id = t3.id
GROUP BY t2.name
HAVING AVG(price) > 5000;