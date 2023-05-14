INSERT INTO role(name)
VALUES ('Заказчик'), ('Разработчик'), ('Менеджер');

INSERT INTO users(name, role_id)
VALUES ('Петр', 1), ('Александр', 2), ('Мария', 3);

INSERT INTO rules(name)
VALUES
('Взаимодействие с разработчиками'),
('Управляет ожиданиями заказчика'),
('Взаимодействует с менеджерами проекта'),
('Имеет право изменять требования к продукту'),
('Принимает технические решения'),
('Имеет право на изменение программного кода системы');

INSERT INTO role_rules(role_id, rule_id)
VALUES
(1, 3), (1, 4),
(2, 3), (2,5), (2, 6),
(3, 1), (3, 2);

INSERT INTO category(name)
VALUES
('Встреча с менеджером'),
('Встреча с разработчиками'),
('Встреча с заказчиком');

INSERT INTO state(name)
VALUES
('Заявка отменена'),
('Заявка открыта'),
('Заявка завершена'),
('Заявка приостановлена'),
('Заявка в исполнении');

INSERT INTO item(user_id, category_id, state_id)
VALUES
(1, 1, 2),
(2, 1, 3),
(3, 3, 5),
(3, 2, 3);

INSERT INTO comments(description, item_id)
VALUES
('Обсудить задачу N1 ...', 1),
('Закрыли задачу N2 ...', 2),
('Обсудить задачу N3 ...', 3),
('Закрыли задачу N4 ...', 4);

INSERT INTO attachs(name, item_id)
VALUES
('file1.txt', 1),
('file2.txt', 2),
('file3.txt', 3),
('file4.txt', 4);