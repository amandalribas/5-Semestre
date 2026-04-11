use sakila;
show tables;

-- Testando alterar visões com visões com groupy by:
select * from film_category;

create view view_film_total as
select category_id, count(*) as film_total
from film_category
group by category_id;

select * from view_film_total;

update view_film_total 
set film_total = 10
where category_id = 1;
-- Error Code: 1288. The target table view_film_total of the UPDATE is not updatable	0.000 sec

-- Transformando de 1 -> N para N -> N:
-- Considerando que a tabela film_categories já aceita N..N 
select * from category;
select * from film;
select * from film_category;

create view view_film_category as
select f.title, f.film_id, GROUP_CONCAT(c.name ORDER BY c.name SEPARATOR ', ') AS categories,
    COUNT(c.category_id) AS total_categories
from film f inner join film_category f_c using (film_id) 
inner join category c using (category_id)
group by f.film_id;

insert into film_category (film_id, category_id)
values (1, 2);
-- atualizo na tabela original e verifico na visão.

select * from view_film_category;

drop view view_film_category;