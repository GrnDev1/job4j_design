create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

insert into products (name, producer, count, price)
VALUES
('product_1', 'producer_1', 3, 50),
('product_2', 'producer_2', 15, 32),
('product_3', 'producer_3', 8, 115);

begin transaction;

insert into products (name, producer, count, price)
VALUES
('product_4', 'producer_4', 4, 40),
('product_5', 'producer_5', 5, 55);

commit transaction;

select * from products;

begin transaction;

delete from products;
drop table products;

rollback transaction;

begin transaction;

savepoint first_savepoint;

select * from products;

DELETE
FROM products
WHERE id IN (1, 2, 3);

savepoint second_savepoint;
select * from products;

rollback to first_savepoint;
select * from products;

commit;