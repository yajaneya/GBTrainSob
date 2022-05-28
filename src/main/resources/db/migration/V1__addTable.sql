create table if not exists students (id bigserial primary key, name varchar(255), age int);

insert into students (name, age)
values
('Vasilii', 20),
('Anastasiya', 22),
('Petr', 25),
('Alina', 23);
