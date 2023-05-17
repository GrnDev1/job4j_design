CREATE TABLE products (
    id serial PRIMARY KEY,
    name varchar(50),
    producer varchar(50),
    count integer DEFAULT 0,
    price integer
);

CREATE TABLE history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

CREATE FUNCTION insert_func()
RETURNS TRIGGER AS
$$
BEGIN
INSERT INTO history_of_price (name, price, date)
VALUES (NEW.name, NEW.price, current_date);
RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';


CREATE TRIGGER trigger3
AFTER INSERT
ON products
FOR EACH ROW
EXECUTE PROCEDURE insert_func();

INSERT INTO products (name, producer, count, price)
VALUES
('product_1', 'producer_1', 3, 50);

SELECT *
FROM history_of_price;

SELECT *
FROM products;

DROP TRIGGER trigger3 on products;
DROP FUNCTION insert_func;
DROP TABLE products;
