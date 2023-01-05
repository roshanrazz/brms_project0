/*
	AUTHOR : ROSHAN SAH
    DATE :	 2023-01-03
*/

DROP DATABASE IF EXISTS brmsdb;

CREATE DATABASE brmsdb;

USE brmsdb;

--------- users table --------

DROP TABLE IF EXISTS users;

CREATE TABLE users (
id_proof_num INT PRIMARY KEY,
name varchar(20),
username varchar(20) UNIQUE NOT NULL,
password varchar(16),
email varchar (30),
phone_num varchar(15),
address VARCHAR(50),
dob date,
physical_disability tinyint,
isadmin tinyint
);


------- inserting without stored procedure --------
/*
INSERT INTO users
(id_proof_num,name,username,password,email,phone_num,address,dob,physical_disability,isadmin)
VALUES
(1,"Jack Jack","imjack","qwdy@123","jack@demo.com","987654321","USA","2000-02-27",0,0),
(2,"Rock Jack","imrockjack","qwerty@123","jrockjack@demo.com","9876564151","Bhutan","1999-05-25",1,0),
(3,"Jack Rock","imrock","qwesddy@123","rock@demo.com","98596621","Nepal","2001-08-14",0,0),
(4,"Amki Yadv","imamki","wdwd@123","ami@demo.com","98768466","India","1994-07-27",0,0),
(5,"Rock Rok","imrok","qwer@6563","rock@demo.com","96956551","UK","2003-12-01",0,1);

*/


--------- using stored procedure to insert into users table --------
DELIMITER $$
CREATE PROCEDURE users_insert (in id_proof_num int,in name varchar(20),in username varchar(20),in password varchar(16),in email varchar(30),in phone_num varchar(15),in address varchar(50),in dob date,in physical_disability tinyint,in isadmin tinyint)
BEGIN
INSERT INTO users (id_proof_num,name,username,password,email,phone_num,address,dob,physical_disability,isadmin)
VALUES
(id_proof_num,name,username,password,email,phone_num,address,dob,physical_disability,isadmin);
END$$
DELIMITER ;

CALL users_insert (1,"Jack Jack","imjack","qwdy@123","jack@demo.com","987654321","USA","2000-02-27",0,0);
CALL users_insert (2,"Rock Jack","imrockjack","qwerty@123","jrockjack@demo.com","9876564151","Bhutan","1999-05-25",1,0);
CALL users_insert (3,"Jack Rock","imrock","qwesddy@123","rock@demo.com","98596621","Nepal","2001-08-14",0,0);
CALL users_insert (4,"Amki Yadv","imamki","wdwd@123","ami@demo.com","98768466","India","1994-07-27",0,0);
CALL users_insert (5,"Rock Rok","imrok","qwer@6563","rock@demo.com","96956551","UK","2003-12-01",0,1);


SELECT * from users;

--- show age --

select *,CURDATE() as today,
TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age from users;

--- show admins -----

select * from users where
isadmin=1;

-------------------------------- users table end ----------------------------------------------------


---------------------- create table route ----------

DROP TABLE IF EXISTS route;

CREATE TABLE route
(
source varchar(30),
destination varchar(30)
);

SELECT * from route;

----------- bus table -------

DROP TABLE IF EXISTS bus_info;

CREATE TABLE bus_info
(
bus_registration_num VARCHAR(15) PRIMARY KEY,
bus_name VARCHAR (40),
bus_type varchar (6),
bus_capacity tinyint,
bus_seat_type VARCHAR(10)
);

SELECT * from bus_info;

------------ trip table ------

DROP TABLE IF EXISTS trip_info;

CREATE TABLE trip_info
(
bus_registraion_num VARCHAR(15),
source varchar(30),
destination varchar(30),
boarding_time date,
arrival_time date,
ticket_charge int,
FOREIGN KEY(bus_registraion_num) REFERENCES bus_info (bus_registration_num)
);

SELECT * from trip_info;


---------- ticket registration -------

DROP TABLE IF EXISTS ticket_registration;

CREATE TABLE ticket_registration
(
ticket_number VARCHAR(20) PRIMARY KEY,
name VARCHAR (30),
age date,
source varchar(30),
destination varchar(30),
boarding_time date,
arrival_time date,
bus_registraion_num VARCHAR(15)
);

SELECT * FROM ticket_registration;

