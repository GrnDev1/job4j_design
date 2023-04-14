CREATE TABLE employee(
	id serial primary key,
	profession VARCHAR(50),
	salary DECIMAL(8,2),
	working_hours INT
);
INSERT INTO employee(profession, salary, working_hours)
VALUES('Teacher', 335.5, 160);
UPDATE employee SET salary = 400, working_hours = 180;
DELETE FROM employee;
SELECT * FROM employee;