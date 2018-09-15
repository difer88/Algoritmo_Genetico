create database transportanalysis;

use transportanalysis;

create table products (
	product_id int not null auto_increment,
    product_name varchar(50) not null,
    used_space float not null,
    product_value float not null,
    quantity int not null,
    constraint pk_product_productid primary key (product_id)
);

drop table products;

select * from products;

delete from products where product_id > 0;

insert into products (product_name, used_space, product_value, quantity) values('Geladeira Electrolux', 0.751, 999.90, 2);
insert into products (product_name, used_space, product_value, quantity) values('Geladeira Brastemp', 0.635, 849.00, 4);
insert into products (product_name, used_space, product_value, quantity) values('Geladeira Consul', 0.870, 1199.89, 3);
insert into products (product_name, used_space, product_value, quantity) values('Notebook Lenovo', 0.498, 1999.90, 12);
insert into products (product_name, used_space, product_value, quantity) values('Notebook Asus', 0.527, 3999.00, 9);
insert into products (product_name, used_space, product_value, quantity) values('Notebook Dell', 0.00350, 2499.90, 23);
insert into products (product_name, used_space, product_value, quantity) values('Microondas Sanyo', 0.0424, 308.66, 7);
insert into products (product_name, used_space, product_value, quantity) values('Microondas LG', 0.0544, 429.90, 6);
insert into products (product_name, used_space, product_value, quantity) values('Microondas Panasonic', 0.0319, 299.29, 11);
insert into products (product_name, used_space, product_value, quantity) values('TV 55', 0.400, 4346.99, 14);
insert into products (product_name, used_space, product_value, quantity) values('TV 50', 0.290, 3999.90, 13);
insert into products (product_name, used_space, product_value, quantity) values('TV 42', 0.200, 2999.00, 28);
insert into products (product_name, used_space, product_value, quantity) values('Iphone 6', 0.000089, 2911.12, 17);
insert into products (product_name, used_space, product_value, quantity) values('Ventilador Ventisol', 0.496, 199.90, 21);

SELECT * FROM 	products ORDER BY 	product_id ASC