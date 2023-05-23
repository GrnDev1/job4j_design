CREATE TABLE customers(
                          id serial primary key,
                          first_name text,
                          last_name text,
                          age int,
                          country text
);

INSERT INTO customers(first_name, last_name, age, country)
VALUES
('Petr', 'Petrov', 40, 'Russia'),
('Ivan', 'Ivanov', 30, 'Russia'),
('Roman', 'Romanov', 27, 'Russia');

SELECT *
FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

CREATE TABLE orders(
                       id serial primary key,
                       amount int,
                       customer_id int references customers(id)
);

INSERT INTO orders(amount, customer_id)
VALUES
(1000, 1), (3000, 2), (5000, 2);

SELECT *
FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders);