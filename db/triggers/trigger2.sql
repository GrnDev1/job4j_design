CREATE TABLE products (
    id serial PRIMARY KEY,
    name varchar(50),
    producer varchar(50),
    count integer DEFAULT 0,
    price integer
);

CREATE FUNCTION tax()
RETURNS TRIGGER AS
$$
BEGIN
NEW.PRICE = NEW.PRICE + NEW.PRICE * 0.2;
RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';


CREATE TRIGGER tax_trigger
BEFORE INSERT
ON products
FOR EACH ROW
EXECUTE PROCEDURE tax();


INSERT INTO products (name, producer, count, price)
VALUES
('product_1', 'producer_1', 3, 50);

SELECT *
FROM products;

DELETE
FROM products;

DROP TRIGGER tax_trigger on products;
DROP FUNCTION tax;
DROP TABLE products;