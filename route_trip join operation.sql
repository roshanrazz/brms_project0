
use brmsdb;

select * from route inner join trip
where
route.Bus_Registration_number=trip.Bus_Registration_number;
