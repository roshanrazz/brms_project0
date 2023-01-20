
use brmsdb;


drop table if exists route;

CREATE TABLE `route` (
  `Route_Id` varchar(10) NOT NULL,
  `Bus_Registration_number` varchar(10) DEFAULT NULL,
  `Source` varchar(20) DEFAULT NULL,
  `Destination` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Route_Id`)
) ;

INSERT INTO ROUTE
VALUES
("R001","AL-7896","MUMBAI","SHRIDI");

INSERT INTO ROUTE
VALUES
("R002","BC-1234","DELHI","SHRIDI");

INSERT INTO ROUTE
VALUES
("R003","DC-1245","MUMBAI","SHRIDI");

UPDATE ROUTE
SET
SOURCE="NEW DELHI"
WHERE
Bus_Registration_number="BC-1234";


SELECT * FROM ROUTE;

DELETE FROM ROUTE
WHERE
Bus_Registration_number="BC-1234";

SELECT * FROM ROUTE;
