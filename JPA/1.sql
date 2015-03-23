create database test_db;
create table human (id int, first_name varchar(100), last_name varchar(100), gender varchar(100), age int);

select * from human;

GRANT ALL PRIVILEGES ON HUMAN TO sa;

show dbs;