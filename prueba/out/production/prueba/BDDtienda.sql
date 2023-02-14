CREATE DATABASE Tienda_abarrotes;
USE Tienda_abarrotes;


CREATE TABLE IF NOT EXISTS producto(
	Id int primary key auto_increment,
    Nombre varchar(60), 
    Descripcion varchar(60),
	Precio numeric(6,2)
);

ALTER TABLE producto
ADD COLUMN Categoria varchar(50);

ALTER TABLE producto
DROP COLUMN Fecha

SELECT * FROM producto