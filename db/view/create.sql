CREATE TABLE students(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO students(name)
VALUES
('Иван Иванов'),('Петр Петров'),
('Роман Романов'),('Сергей Сергеев'),
('Юрий Юрьев'),('Алексей Алексеев');

CREATE TABLE authors(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO authors(name)
VALUES ('Александр Пушкин'),('Николай Гоголь'),
('Антон Чехов'),('Лев Толстой'),
('Федор Достоевский'),('Иван Тургенев');

create table books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    author_id INTEGER REFERENCES authors(id)
);

INSERT INTO books(name, author_id)
VALUES
('Евгений Онегин', 1),('Капитанская дочка', 1),('Дубровский', 1),
('Мертвые души', 2),('Вий', 2),
('Вишневый сад', 3),('Дама с собачкой', 3),
('Война и мир', 4),('Детство', 4),
('Идиот', 5),('Белые ночи', 5),
('Отцы и дети', 6),('Муму', 6);

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    active BOOLEAN DEFAULT TRUE,
    book_id INTEGER REFERENCES books(id),
    student_id INTEGER REFERENCES students(id)
);

INSERT INTO orders(book_id, student_id)
VALUES
(1, 1),(12, 1),
(5, 2),(7, 2),
(3, 3),
(6, 4),(3, 4),(1, 4),
(8, 5),(2, 5),(5, 5),
(5, 6),(8, 6);