

CREATE TABLE cash (
    payment_number varchar(16) NOT NULL,
    office_collected varchar(45) NOT NULL,
    cash_collected decimal(50,2) NOT NULL,
    CONSTRAINT cash_pk PRIMARY KEY (office_collected)
);

CREATE TABLE city (
    city_name varchar(45) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (city_name)
);


CREATE TABLE credit_card (
    payment_number varchar(25) NOT NULL,
    card_company varchar(45) NOT NULL,
    billing_address varchar(45) NOT NULL,
    zipcode int NOT NULL,
    city_name varchar(45) NOT NULL,
    state varchar(45) NOT NULL,
    CONSTRAINT credit_card_pk PRIMARY KEY (card_company)
);


CREATE TABLE indoor (
    lot_number varchar(10) NOT NULL,
    building varchar(45) NOT NULL,
    floor int NOT NULL,
    size_slot int NOT NULL,
    open_hour time NOT NULL,
    end_hour time NOT NULL,
    CONSTRAINT indoor_pk PRIMARY KEY (building,floor)
);


CREATE TABLE model (
    make varchar(45) NOT NULL,
    model varchar(45) NOT NULL,
    CONSTRAINT model_pk PRIMARY KEY (model)
);

CREATE TABLE one_time_parking (
    lot_number varchar(10) NOT NULL,
    vehicle_plate_number varchar(20) NOT NULL,
    is_paid bool NOT NULL,
    hour_parked double(10,2) NOT NULL,
    net_cost int NOT NULL,
    CONSTRAINT one_time_parking_pk PRIMARY KEY (hour_parked)
);


CREATE TABLE outdoor (
    lot_number varchar(10) NOT NULL,
    street_name varchar(45) NOT NULL,
    size_of_slot int NOT NULL,
    CONSTRAINT outdoor_pk PRIMARY KEY (street_name)
);

CREATE TABLE parking_lot (
    lot_number varchar(10) NOT NULL,
    is_resevered bool NOT NULL,
    is_available bool NOT NULL,
    is_permit_only bool NOT NULL,
    hour_used decimal(30,2) NOT NULL,
    CONSTRAINT parking_lot_pk PRIMARY KEY (lot_number)
);
CREATE TABLE parking_price (
    lot_number varchar(10) NOT NULL,
    all_day_cost int NOT NULL,
    cost_per_hour int NOT NULL,
    hour_limit int NOT NULL,
    is_holiday bool NOT NULL,
    CONSTRAINT parking_price_pk PRIMARY KEY (is_holiday)
);


CREATE TABLE payment (
    user_username varchar(16) NOT NULL,
    user_password varchar(32) NOT NULL,
    payment_number varchar(25) NOT NULL,
    CONSTRAINT payment_pk PRIMARY KEY (payment_number)
);


CREATE TABLE permit (
    price int NOT NULL,
    duration int NOT NULL,
    begin_date date NOT NULL,
    end_date date NOT NULL,
    permit_type varchar(20) NOT NULL,
    CONSTRAINT permit_pk PRIMARY KEY (permit_type)
);

CREATE TABLE purchase_pemit (
    username varchar(16) NOT NULL,
    password varchar(32) NOT NULL,
    payment_number varchar(25) NOT NULL,
    permit_type varchar(20) NOT NULL,
    paid_date date NOT NULL,
    lot_number varchar(10) NOT NULL,
    CONSTRAINT purchase_pemit_pk PRIMARY KEY (paid_date)
);


CREATE TABLE staff (
    is_Admin int NOT NULL,
    user_username varchar(16) NOT NULL,
    user_password varchar(32) NOT NULL,
    CONSTRAINT staff_pk PRIMARY KEY (is_Admin)
);

CREATE TABLE student (
    enrolled_year int NOT NULL,
    graduation_year int NOT NULL,
    user_username varchar(16) NOT NULL,
    user_password varchar(32) NOT NULL,
    is_live_campus bool NOT NULL,
    CONSTRAINT student_pk PRIMARY KEY (is_live_campus)
);


CREATE TABLE user (
    username varchar(16) NOT NULL,
    password varchar(32) NOT NULL,
    email varchar(255) NOT NULL,
    last_name varchar(45) NOT NULL,
    first_name varchar(45) NOT NULL,
    phone int NOT NULL,
    vehicle_plate_number varchar(20) NOT NULL,
    CONSTRAINT password PRIMARY KEY (username,password)
);


CREATE TABLE vehicle (
    year int NOT NULL,
    color varchar(15) NOT NULL,
    vehicle_plate_number varchar(20) NOT NULL,
    model varchar(45) NOT NULL,
    CONSTRAINT vehicle_pk PRIMARY KEY (vehicle_plate_number)
);


ALTER TABLE indoor ADD CONSTRAINT Table_14_parking_lot FOREIGN KEY Table_14_parking_lot (lot_number)
    REFERENCES parking_lot (lot_number);


ALTER TABLE credit_card ADD CONSTRAINT Table_6_payment FOREIGN KEY Table_6_payment (payment_number)
    REFERENCES payment (payment_number);


ALTER TABLE cash ADD CONSTRAINT cash_payment FOREIGN KEY cash_payment (payment_number)
    REFERENCES payment (payment_number);


ALTER TABLE credit_card ADD CONSTRAINT credit_card_city FOREIGN KEY credit_card_city (city_name)
    REFERENCES city (city_name);


ALTER TABLE one_time_parking ADD CONSTRAINT one_time_parking_parking_lot FOREIGN KEY one_time_parking_parking_lot (lot_number)
    REFERENCES parking_lot (lot_number);

ALTER TABLE one_time_parking ADD CONSTRAINT one_time_parking_vehicle FOREIGN KEY one_time_parking_vehicle (vehicle_plate_number)
    REFERENCES vehicle (vehicle_plate_number);


ALTER TABLE outdoor ADD CONSTRAINT outdoor_parking_lot FOREIGN KEY outdoor_parking_lot (lot_number)
    REFERENCES parking_lot (lot_number);


ALTER TABLE parking_price ADD CONSTRAINT parking_price_parking_lot FOREIGN KEY parking_price_parking_lot (lot_number)
    REFERENCES parking_lot (lot_number);


ALTER TABLE payment ADD CONSTRAINT payment_user FOREIGN KEY payment_user (user_username,user_password)
    REFERENCES user (username,password);

ALTER TABLE purchase_pemit ADD CONSTRAINT purchase_pemit_parking_lot FOREIGN KEY purchase_pemit_parking_lot (lot_number)
    REFERENCES parking_lot (lot_number);

ALTER TABLE purchase_pemit ADD CONSTRAINT purchase_pemit_payment FOREIGN KEY purchase_pemit_payment (payment_number)
    REFERENCES payment (payment_number);


ALTER TABLE purchase_pemit ADD CONSTRAINT purchase_pemit_permit FOREIGN KEY purchase_pemit_permit (permit_type)
    REFERENCES permit (permit_type);


ALTER TABLE purchase_pemit ADD CONSTRAINT purchase_pemit_user FOREIGN KEY purchase_pemit_user (username,password)
    REFERENCES user (username,password);


ALTER TABLE student ADD CONSTRAINT student_user FOREIGN KEY student_user (user_username,user_password)
    REFERENCES user (username,password);


ALTER TABLE staff ADD CONSTRAINT teacher_user FOREIGN KEY teacher_user (user_username,user_password)
    REFERENCES user (username,password);


ALTER TABLE user ADD CONSTRAINT user_vehicle FOREIGN KEY user_vehicle (vehicle_plate_number)
    REFERENCES vehicle (vehicle_plate_number);


ALTER TABLE vehicle ADD CONSTRAINT vehicle_model FOREIGN KEY vehicle_model (model)
    REFERENCES model (model);


