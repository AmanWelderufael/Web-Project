BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE SEQUENCE address_serial;
CREATE TABLE address (
	address_id int NOT NULL DEFAULT nextval ('address_serial'),
	street_number int NOT NULL,
	street_name varchar(50) NOT NULL,
	city_name varchar(50) NOT NULL,
	state_name varchar(50) NOT NULL,
	zip_code varchar(50) NOT NULL,
	latitude float,
	longitude float,
	CONSTRAINT pk_address PRIMARY KEY (address_id)
);

CREATE SEQUENCE landmark_serial;
CREATE TABLE landmark (
    landmark_id int NOT NULL DEFAULT nextval('landmark_serial'),
    address_id int NOT NULL,
    landmark_name varchar(50) NOT NULL,
    landmark_description varchar(200),
    CONSTRAINT PK_landmark PRIMARY KEY(landmark_id),
    CONSTRAINT FK_address_id FOREIGN KEY(address_id) REFERENCES address(address_id)
);

CREATE SEQUENCE itinerary_serial;
CREATE TABLE itinerary (
    itinerary_id int NOT NULL DEFAULT nextval('itinerary_serial'),
    user_id int NOT NULL,
    itinerary_name varchar(50) NOT NULL,
    starting_landmark_id int,

    CONSTRAINT PK_itinerary PRIMARY KEY(itinerary_id),
    CONSTRAINT FK_itinerary_user FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT FK_itinerary_landmark FOREIGN KEY(starting_landmark_id) REFERENCES landmark(landmark_id)
);

CREATE TABLE landmark_itinerary (
    landmark_id int NOT NULL,
    itinerary_id int NOT NULL,
    CONSTRAINT pk_landmark_itinerary PRIMARY KEY (landmark_id, itinerary_id),
    CONSTRAINT fk_landmark_itinerary_itinerary FOREIGN KEY (itinerary_id) references itinerary(itinerary_id),
    CONSTRAINT fk_landmark_itinerary_landmark FOREIGN KEY (landmark_id) references landmark(landmark_id)
);




COMMIT TRANSACTION;
