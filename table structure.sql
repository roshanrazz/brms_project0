CREATE DATABASE `brmsdb`;

use brmsdb;







---------- create table ROUTE--------
DROP TABLE IF EXISTS route;
CREATE TABLE `route` (
  `Route_Id` varchar(10) NOT NULL,
  `Bus_Registration_number` varchar(10) DEFAULT NULL,
  `Source` varchar(20) DEFAULT NULL,
  `Destination` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Route_Id`)
) ;



---------- create table trip--------


DROP TABLE IF EXISTS trip;
CREATE TABLE `trip` (
  `Bus_Registration_number` varchar(10) NOT NULL,
  `boarding_time` time DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `ticket_charge` int DEFAULT NULL,
  PRIMARY KEY (`Bus_Registration_number`)
);




