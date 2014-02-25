insert into user (id, firstName, lastName, email, nickname, sessionId, facebookId) values (1, 'Honda', 'Prius', '40mpg@gmail.com', 'hybrid', 'hybrid', 'hybridfbid');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (2, 'Ned', 'Stark', 'naked@winterfell.com', 'headless', 'nedstark');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (3, 'Jack', 'Handy', 'jh1942@lion.lmu.edu', 'DeepThoughts', 'jackhandy');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (4, 'Heather', 'Northington', 'h.north@lion.lmu.edu', 'hnorth', 'heathernorthington');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (5, 'Ignatius', 'Krumpkin', 'iggy@hotmail.com', 'IKOK', 'ignatius');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (6, 'Eva', 'Sandleborn', 'eva@htomail.com', 'sandy', 'eva');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (7, 'Olga', 'Shoopa', 'olga@gmail.com', 'gaah', 'olga');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (8, 'Katrina', 'Sherbina', 'ksherbina@gmail.com', 'Kat', 'katrina');
insert into user (id, firstName, lastName, email, nickname, facebookId) values (10, 'Richard', 'Brous', 'rbrous@gmail.com', 'Brousy', '589159502');
insert into user (id, firstName, lastName, email, nickname, sessionId) values (3503, 'John', 'Lennon', 'jlennon@gmail.com', 'John', 'john');
insert into user (id, firstName, lastname, email, nickname, sessionId) values (155, 'Carlos', 'Agudo', 'cagudo@gmail.com', 'Carlito', 'carlos');
insert into user (id, firstName, lastname, email, nickname, facebookId) values (3504, 'Sam', 'Verhasselt', 'azureus42@yahoo.com', 'Sam Verhasselt','777892175');

insert into event (name, description, ownerId) values ('Poker Night', 'Cards with the guys', 8);
insert into event (name, description, ownerId) values ('Billiards with Prince Harry', 'Pool and drinks', 7);
insert into event (name, description, ownerId) values ('Dinner with Barack and Michelle', 'A presidential meal', 6);
insert into event (name, description, ownerId) values ('Sunset Strip Music Festival', 'West Hollywood hosts music event', 5);
insert into event (name, description, ownerId) values ('Ballyshannon Music Festival', 'Irish music festival', 4);
insert into event (name, description, ownerId) values ('2012 Olympic Women''s Soccer Final', 'The final Women''s Soccer game', 3);
insert into event (name, description, ownerId) values ('Weekly Hackathon', 'Show your hackin'' skeelz', 2);
insert into event (name, description, ownerId) values ('Ironman Triathlon Practice', 'Don''t miss out', 1);

insert into venue (id, name, address, latitude, longitude) values (1, 'Pantages Theater', '6233 Hollywood Bl, Los Angeles, CA', 34.1019444, -118.3261111);
insert into venue (id, name, address, latitude, longitude) values (2, 'Hollywood Bowl', '2301 North Highland Ave, Hollywood, CA', 34.1127863, -118.3392439);
insert into venue (id, name, address, latitude, longitude) values (3, 'Tochka', '8915 Sunset Bl, West Hollywood, CA', 34.090608, -118.386178);
insert into venue (id, name, address, latitude, longitude) values (4, 'Griffith Observatory', '2800 East Observatory Rd, Los Angeles, CA 90027', 0, 0);
insert into venue (id, name, address, latitude, longitude) values (5, 'The Roxy', '9009 West Sunset Bl, West Hollywood, CA 90069', 34.123408, -118.302409);
insert into venue (id, name, address, latitude, longitude) values (6, 'The Viper Room', '8852 West Sunset Bl, West Hollywood, CA 90069', 34.090512, -118.384657);
insert into venue (id, name, address, latitude, longitude) values (7, 'House of Blues Sunset Strip', '8430 Sunset Bl, West Hollywood, CA', 34.094950, -118.373779);
insert into venue (id, name, address, latitude, longitude) values (8, 'Carousel Restaurant', '304 N Brand Bl, Glendale, CA 91203', 34.149885, -118.255108);
insert into venue (id, name, address, latitude, longitude) values (10, 'Far Away Palace', '71 Longa way, SomeTown, ZX 90145', -34.149885, 62.000001);
insert into venue (id, name, address, latitude, longitude) values (11, 'Some trailer park', '2800 East Observatory Rd, Los Angeles, CA 90027', 0, 0);

insert into venue_property (venueId, key, value) values (1, 'seating capacity', '2703');
insert into venue_property (venueId, key, value) values (1, 'since', '1930-06-04');
insert into venue_property (venueId, key, value) values (1, 'cross street', 'Argyle');
insert into venue_property (venueId, key, value) values (2, 'Ages', '18+');
insert into venue_property (venueId, key, value) values (2, 'Parking', 'Valet only');
insert into venue_property (venueId, key, value) values (3, 'cuisine', 'mediterranean');
insert into venue_property (venueId, key, value) values (3, 'parking', 'street');
insert into venue_property (venueId, key, value) values (5, 'fax', '310-278-2447');
insert into venue_property (venueId, key, value) values (5, 'twitter', '@theroxy');
insert into venue_property (venueId, key, value) values (7, 'url', 'http://www.houseofblues.com/');

insert into occurrence (id, eventId, venueId, start, end) values (1, 2, 1, '2012-01-15 20:00:00', '2012-01-16 02:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (2, 6, 2, '2012-02-15 20:00:00', '2012-02-16 02:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (3, 5, 3, '2012-03-15 20:00:00', '2012-03-16 02:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (4, 8, 4, '2012-04-15 20:00:00', '2012-04-16 02:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (5, 3, 5, '2012-05-15 20:00:00', '2012-05-16 02:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (6, 2, 1, '2012-11-15 01:00:00', '2012-11-15 15:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (7, 6, 2, '2012-11-16 02:00:00', '2012-11-16 16:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (8, 5, 3, '2012-11-17 03:00:00', '2012-11-17 17:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (9, 8, 4, '2012-11-18 04:00:00', '2012-11-18 18:30:00');
insert into occurrence (id, eventId, venueId, start, end) values (10, 3, 5, '2012-11-19 05:00:00', '2012-11-19 19:30:00');

insert into category (id, name, parentId) values (1, 'Theater', null);
insert into category (id, name, parentId) values (2, 'Club', null);

insert into category (id, name, parentId) values (3, 'Comedy', 1);

insert into event_category (eventId, categoryId) values (1, 1);

insert into attendee (occurrenceId, userId) values (1, 1);
insert into attendee (occurrenceId, userId) values (1, 2);
insert into attendee (occurrenceId, userId) values (2, 1);

insert into event_comment (id, subjectId, authorId, text, timestamp) values (1, 1, 1, 'Boo, sux', '2012-03-17T00:00:00');
insert into event_comment (id, subjectId, authorId, text, timestamp) values (2, 2, 2, 'Boo, sux', '2012-03-17T00:00:00');

insert into occurrence_comment(id, subjectId, authorId, text, timestamp) values (1, 1, 3503, 'Aww yeah.', '2012-04-18T00:00:00');
insert into occurrence_comment(id, subjectId, authorId, text, timestamp) values (2, 1, 3503, 'Aww no.', '2012-04-18T00:00:00');
insert into occurrence_comment(id, subjectId, authorId, text, timestamp) values (3, 5, 3503, 'Aww yeah.', '2012-04-18T00:00:00');

insert into venue_comment (id, subjectId, authorId, text, timestamp) values (1, 10, 1, 'This venue sux.', '2012-03-30T12:34:56');
insert into venue_comment (id, subjectId, authorId, text, timestamp) values (2, 10, 2, 'My life is a sham', '2012-12-25T07:00:00');
insert into venue_comment (id, subjectId, authorId, text, timestamp) values (3, 6, 1, 'pizza pizza', '2012-12-25T07:00:00');
