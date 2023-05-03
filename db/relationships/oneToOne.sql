CREATE TABLE students(
id SERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE accounts(
id SERIAL PRIMARY KEY,
login VARCHAR(255),
password VARCHAR(255)
);

CREATE TABLE students_accounts(
id SERIAL PRIMARY KEY,
student_id INT REFERENCES students(id) UNIQUE,
account_id INT REFERENCES accounts(id) UNIQUE
);

INSERT INTO students(name)
VALUES('Alex Ivanov'), ('Ivan Romanov');

INSERT INTO accounts (login, password)
VALUES ('81604', 'pasw23'), ('81852', 'myP2as3w');

INSERT INTO students_accounts(student_id, account_id)
VALUES (1,2), (2,1);

SELECT *
FROM students;

SELECT *
FROM accounts;

SELECT *
FROM students_accounts;