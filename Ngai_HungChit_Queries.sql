-- find who is admin
select last_name,first_name
from staff
join user
on staff.user_username=user.username
where is_Admin=1;

-- find which parking lot is available
select lot_number
from parking_lot
where is_available=1;

-- find which parking has highest usage
select lot_number,max(hour_used) usage1
from parking_lot;

-- find the payment history
select *
from payment;


-- find all permit type and price
select permit_type, price
from permit;

-- find out the price that people need to pay for on time parking
select lot_number,net_cost
from one_time_parking;
 
 -- find out the vehicle that park for one time parking
 select lot_number,vehicle_plate_number,color,model
 from one_time_parking
 join vehicle
 on one_time_parking.vehicle_plate_number=vehicle.vehicle_plate_number;
 
 -- find the list of vehicle
 select vehicle_plate_number,make,model,year
 from vehicle
 join model
 on vehicle.model=model.model;
 
 -- find the permit that purchased
 select permit_type,lot_number,paid_date
 from purchase_pemit;