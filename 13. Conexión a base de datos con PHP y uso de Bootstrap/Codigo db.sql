create database registros;
use registros;

create table usuarios(
id int unique auto_increment,
nombre varchar(20) not null,
apellido varchar(20) not null,
email varchar(30) unique not null,
telefono varchar(10) unique not null,
direccion varchar(30) not null,
primary key(id));

describe usuarios;
select * from usuarios;