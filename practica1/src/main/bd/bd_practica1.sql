DROP DATABASE IF EXISTS bd_practica1;
CREATE DATABASE bd_practica1;
USE bd_practica1;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `cboseccion`;
CREATE TABLE `cboseccion`(
codigo int not null AUTO_INCREMENT primary key,
descripcion varchar (50) not null
);
insert into `cboseccion` values (1,'Todos');
insert into `cboseccion` values (2,'Ninguno');
insert into `cboseccion` values (3,'Puede sher');
insert into `cboseccion` values (4,'Otro dia');
insert into `cboseccion` values (5,'Ya pero eres o no eres?');

DROP TABLE IF EXISTS `formulario`;
CREATE TABLE `formulario`(
codigoFor int not null AUTO_INCREMENT primary key,
nombre varchar (50) null,
codigo int  references cboseccion,
FechaDeNacimiento   date,
FechaActual   datetime null
);

insert into `formulario` values (null,'Jose',1,'2020-10-11',null);
insert into `formulario` values (null,'Pepe',2,'2020-10-11',null);
insert into `formulario` values (null,'wewe',3,'2020-10-11',null);
insert into `formulario` values (null,'Pipi',4,'2020-10-11',null);
insert into `formulario` values (null,'asas',4,'2020-10-11',null);

select * from formulario;