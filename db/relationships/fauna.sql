create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values
('Grey Squirrel', 5110, null ),
('Lion', 8766, null),
('Tiger', 7300, '1858-01-01'),
('Leopard', 7300, '1758-01-01'),
('Gorilla', 14600, '1847-01-01'),
('Chimpanzee', 20075, '1799-01-01'),
('Catfish', 2920, null);


SELECT *
FROM fauna
WHERE name LIKE '%fish%';

SELECT *
FROM fauna
WHERE avg_age BETWEEN 10000 AND 21000;

SELECT *
FROM fauna
WHERE discovery_date IS NULL;

SELECT *
FROM fauna
WHERE discovery_date < '1950-01-01';