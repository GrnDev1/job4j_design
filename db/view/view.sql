/*
Определить список студентов, которые
- читают не более одной книги одного автора
- читают не менее двух книг
Отсортировать таблицу сначала по имени студента, потом по имени автора.
Вывести имя студента, название книги, имя автора, количество книг у студента.
*/

CREATE VIEW students_view AS
WITH
tab1 AS (
SELECT t3.name Студент, t4.name Автор, t2.name Книга, COUNT(t2.name) OVER(PARTITION BY t3.name, t4.name) count
FROM orders t1
JOIN books t2 ON t1.book_id = t2.id
JOIN students t3 ON t1.student_id = t3.id
JOIN authors t4 ON t2.author_id = t4.id
GROUP BY Студент, Автор, Книга
),
tab2 AS (
SELECT Студент, Автор, Книга, COUNT(Книга) OVER(PARTITION BY Студент) Количество
FROM tab1
WHERE Студент NOT IN (SELECT Студент FROM tab1 WHERE count > 1)
)

SELECT Студент, Автор, Книга, Количество
FROM tab2
WHERE Количество > 1
ORDER BY Студент, Автор;

SELECT *
FROM students_view;