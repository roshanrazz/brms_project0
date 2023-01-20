use brmsdb;


INSERT INTO TRIP
VALUES
("BC-1234","10:15","14:30",300);

INSERT INTO TRIP
VALUES
("DC-1245","06:15","18:30",500);

INSERT INTO TRIP
VALUES
("AL-7896","08:35","11:30",250);

INSERT INTO TRIP
VALUES
("ML-7896","07:35","11:30",250);

SELECT * FROM trip;

SELECT * FROM trip
WHERE Bus_Registration_number LIKE 'D%';


UPDATE trip
SET
boarding_time = "19:00"
WHERE
Bus_Registration_number = "dc-1245";

SELECT * FROM trip;

DELETE FROM trip
WHERE
Bus_Registration_number="ML-7896";

SELECT * FROM trip;