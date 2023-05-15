CREATE TABLE departments(
id SERIAL PRIMARY KEY,
name VARCHAR(100)
);

CREATE TABLE employees(
id SERIAL PRIMARY KEY,
name VARCHAR(100),
department_id INT REFERENCES departments(id)
);

INSERT INTO departments(name)
VALUES
('Department №1'), ('Department №2'), ('Department №3'),
('Department №4'), ('Department №5'), ('Department №6');

INSERT INTO employees(name, department_id)
VALUES
('Petr', 1), ('Alex', 2), ('Ivan', 3), ('Roman', 4),
('Egor', 1), ('Igor', 2), ('Anna', 3), ('Olga', 4);


SELECT *
FROM departments d
LEFT JOIN employees e
ON e.department_id = d.id
WHERE e.department_id IS NULL

SELECT d.id, d.name, e.department_id, e.name
FROM departments d
LEFT JOIN employees e
ON e.department_id = d.id

SELECT d.id, d.name, e.department_id, e.name
FROM employees e
RIGHT JOIN departments d
ON e.department_id = d.id

CREATE TABLE teens(
id SERIAL PRIMARY KEY,
name VARCHAR(100),
gender VARCHAR(10)
);

INSERT INTO teens(name, gender)
VALUES
('Roman', 'Male'),
('Igor', 'Male'),
('Egor', 'Male'),
('Petr', 'Male'),
('Anna', 'Female'),
('Olga', 'Female'),
('Mariya', 'Female'),
('Sveta', 'Female');

SELECT t1.name, t2.name
FROM teens t1
CROSS JOIN teens t2