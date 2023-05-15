CREATE TABLE type(
id SERIAL PRIMARY KEY,
name VARCHAR(125)
);

CREATE TABLE product(
id SERIAL PRIMARY KEY,
name VARCHAR(125),
type_id INT REFERENCES type(id),
expired_date DATE,
price DECIMAL
);