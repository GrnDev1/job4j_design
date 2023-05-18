create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

-- Процедура удаляет строки по id.

CREATE PROCEDURE delete_data(u_id INTEGER)
AS
$$
BEGIN
DELETE
FROM products
WHERE id = u_id;
END;
$$
LANGUAGE plpgsql;

INSERT INTO products(name, producer, count, price)
VALUES
('product_1', 'producer_1', 10, 100),
('product_2', 'producer_2', 0, 0);

SELECT *
FROM products;

CALL delete_data(2);
DELETE FROM products;

-- Функция возвращает количество удаленных строк.

CREATE FUNCTION delete_data2(u_count INTEGER)
RETURNS INTEGER AS
$$
DECLARE remove_count INTEGER;
BEGIN
remove_count = (SELECT COUNT(id) FROM products);
DELETE
FROM products
WHERE count = u_count;
remove_count = remove_count - (SELECT COUNT(id) FROM products);
RETURN remove_count;
END;
$$
LANGUAGE plpgsql;

INSERT INTO products(name, producer, count, price)
VALUES
('product_1', 'producer_1', 10, 100),
('product_2', 'producer_2', 30, 500),
('product_3', 'producer_3', 40, 500),
('product_4', 'producer_4', 30, 700),
('product_5', 'producer_5', 30, 800);

SELECT *
FROM products;

SELECT delete_data2(30);

DROP TABLE products;
DROP FUNCTION delete_data2;
DROP PROCEDURE delete_data;