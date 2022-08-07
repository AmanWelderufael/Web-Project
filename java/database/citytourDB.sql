BEGIN TRANSACTION;

DROP TABLE IF EXISTS address, landmark, itinerary, landmark_itinerary;
DROP SEQUENCE IF EXISTS address_serial, landmark_serial, itinerary_serial;



CREATE SEQUENCE address_serial;
CREATE TABLE address (
	address_id int NOT NULL DEFAULT nextval ('address_serial'),
	street_number int NOT NULL,
	street_name varchar(50) NOT NULL,
	city_name varchar(50) NOT NULL,
	state_name varchar(50) NOT NULL,
	zip_code varchar(50) NOT NULL,
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

INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (4545, 'Rockefeller Plaza', 'New York', 'NY', 10111);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (1000, '5th Ave', 'New York', 'NY', 10028);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (0, '','New York', 'NY', 10004);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (558, 'Broadway', 'New York', 'NY', 10012);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (30,'Rockefeller Plaza',  'New York', 'NY', 10112);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (200,'Central Park West','New York', 'NY', 10024);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (89,'E 42nd st','New York', 'NY', 10017);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (20, 'Hudson Yards','New York', 'NY', 10001);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (185, 'Greenwich St', 'New York', 'NY', 10006);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (405, 'Lexington Ave', 'New York', 'NY', 10174);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (175, '5th Ave', 'New York', 'NY', 10010);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code) VALUES (1071, '5th Ave', 'New York', 'NY', 10128);


INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (1,'Rockefeller Center', 'Famous complex that is home to TV studios, plus a seasonal ice rink & giant Christmas tree.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (2, 'The Metropolitan Museum of Art', 'The Metropolitan Museum of Art of New York City, colloquially "the Met", is the largest art museum in the Western Hemisphere.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (3, 'The Statue of Liberty', 'The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor in New York City, in the United States.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (4, 'MUSEUM OF ICE CREAM', 'Pink, interactive ice cream-themed museum with a sprinkles pool, subway, 3-floor slide & café.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (5, 'Top of The Rock', 'Observatory on top of Rockefeller Center, with an ocean-liner style design, offering city views.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (6, 'American Museum of Natural History', 'From dinosaurs to outer space and everything in between, this huge museum showcases natural wonders.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (7, 'Grand Central Terminal', 'Grand Central is the southern terminus of the Metro-North Railroads Harlem, Hudson and New Haven Lines, serving the northern parts of the New York metropolitan area.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (8, 'The Vessel' , 'Open-air, honeycomb-shaped attraction offering 16 stories & 80 landings for visitors to climb.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (9, 'The Oculus', 'terminal station on the PATH system, within the World Trade Center complex in the Financial District of Manhattan, New York City. It is served by the Newark–World Trade Center line at all times.' );
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (10,'The Chrysler Building', 'Shimmering art deco skyscraper from 1930 whose spire once made it the worlds tallest building.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (11,'The Flatiron Building', 'Architect Daniel Burnhams iconic 1902 triangular tower nicknamed for its clothes iron look.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (12,'Solomon R. Guggenheim Museum', 'Frank Lloyd Wright–designed modern-art museum with an architecturally significant spiral rotunda.');
commit;


GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE public.address TO final_capstone_appuser;

GRANT ALL ON TABLE public.address TO final_capstone_owner;

GRANT ALL ON TABLE public.address TO postgres;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE public.landmark TO final_capstone_appuser;

GRANT ALL ON TABLE public.landmark TO final_capstone_owner;

GRANT ALL ON TABLE public.landmark TO postgres;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE public.itinerary TO final_capstone_appuser;

GRANT ALL ON TABLE public.itinerary TO final_capstone_owner;

GRANT ALL ON TABLE public.itinerary TO postgres;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE public.address TO final_capstone_appuser;

GRANT ALL ON TABLE public.address TO final_capstone_owner;

GRANT ALL ON TABLE public.address TO postgres;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE public.landmark_itinerary TO final_capstone_appuser;

GRANT ALL ON TABLE public.landmark_itinerary TO final_capstone_owner;

GRANT ALL ON TABLE public.landmark_itinerary TO postgres;





