CREATE TABLE role(
id SERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE users(
id SERIAL PRIMARY KEY,
name VARCHAR(255),
role_id INT REFERENCES role(id)
);

CREATE TABLE rules(
id SERIAL PRIMARY KEY,
name VARCHAR
);

CREATE TABLE role_rules(
id SERIAL PRIMARY KEY,
role_id INT REFERENCES role(id),
rule_id INT REFERENCES rules(id)
);

CREATE TABLE category(
id SERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE state(
id SERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE item(
id SERIAL PRIMARY KEY,
user_id INT REFERENCES users(id),
category_id INT REFERENCES category(id),
state_id INT REFERENCES state(id)
);

CREATE TABLE comments(
id SERIAL PRIMARY KEY,
description VARCHAR,
item_id INT REFERENCES item(id)
);

CREATE TABLE attachs(
id SERIAL PRIMARY KEY,
name VARCHAR(255),
item_id INT REFERENCES item(id)
);