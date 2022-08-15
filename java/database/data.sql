BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (4545, 'Rockefeller Plaza', 'New York', 'NY', 10111, 40.758730, -73.978700);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (1000, '5th Ave', 'New York', 'NY', 10028, 40.779170, -73.962590 );
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (0, '','New York', 'NY', 10004, 40.6892, -74.044502);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (558, 'Broadway', 'New York', 'NY', 10012, 40.7239, -73.9979);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (30,'Rockefeller Plaza',  'New York', 'NY', 10112, 40.7593, -73.9794);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (200,'Central Park West','New York', 'NY', 10024, 40.7813, -73.9740);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (89,'E 42nd st','New York', 'NY', 10017, 40.7527, -73.9772);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (20, 'Hudson Yards','New York', 'NY', 10001, 40.7538, -74.0022);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (185, 'Greenwich St', 'New York', 'NY', 10006, 40.711399, -74.011146);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (405, 'Lexington Ave', 'New York', 'NY', 10174, 40.7516, -73.9755 );
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (175, '5th Ave', 'New York', 'NY', 10010, 40.7411, -73.9897);
INSERT INTO address(street_number, street_name, city_name, state_name, zip_code, latitude, longitude) VALUES (1071, '5th Ave', 'New York', 'NY', 10128, 40.7830, -73.9590);


INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (1,'Rockefeller Center', 'Famous complex that is home to TV studios, plus a seasonal ice rink & giant Christmas tree.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (2, 'The Metropolitan Museum of Art', 'The Metropolitan Museum of Art of New York City, colloquially "the Met", is the largest art museum in the Western Hemisphere.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (3, 'The Statue of Liberty', 'The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor in New York City, in the United States.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (4, 'Museum Of IceCream', 'Pink, interactive ice cream-themed museum with a sprinkles pool, subway, 3-floor slide & café.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (5, 'Top of The Rock', 'Observatory on top of Rockefeller Center, with an ocean-liner style design, offering city views.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (6, 'American Museum of Natural History', 'From dinosaurs to outer space and everything in between, this huge museum showcases natural wonders.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (7, 'Grand Central Terminal', 'Grand Central is the southern terminus of the Metro-North Railroads Harlem, Hudson and New Haven Lines, serving the northern parts of the New York metropolitan area.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (8, 'The Vessel' , 'Open-air, honeycomb-shaped attraction offering 16 stories & 80 landings for visitors to climb.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (9, 'The Oculus', 'terminal station on the PATH system, within the World Trade Center complex in the Financial District of Manhattan, New York City. It is served by the Newark–World Trade Center line at all times.' );
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (10,'The Chrysler Building', 'Shimmering art deco skyscraper from 1930 whose spire once made it the worlds tallest building.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (11,'The Flatiron Building', 'Architect Daniel Burnhams iconic 1902 triangular tower nicknamed for its clothes iron look.');
INSERT INTO landmark (address_id, landmark_name, landmark_description) VALUES (12,'Solomon R. Guggenheim Museum', 'Frank Lloyd Wright–designed modern-art museum with an architecturally significant spiral rotunda.');
COMMIT TRANSACTION;
