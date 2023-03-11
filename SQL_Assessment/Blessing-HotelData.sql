USE BlessingHotel;

INSERT INTO Amenity (description) values ('Microwave'), ("Jacuzzi"), ("Refrigerator"), ("Oven");

INSERT INTO RoomType (description) values ('Single'), ('Double'), ('Suite');

INSERT INTO room (roomNumber, adaAccessible, standardOccupancy, maximumOccupancy, basePrice, extraPerson, roomTypeID) VALUES 
	(201, 'No', 2, 4, 199.99, 10.0, 2),
	(202, 'Yes', 2, 4, 174.99, 10.0, 2),
	(203, 'No', 2, 4, 199.99, 10.0, 2),
	(204, 'Yes', 2, 4, 174.99, 10.0, 2),
	(205, 'No', 2, 2, 174.99, null, 1),
	(206, 'Yes', 2, 2, 149.99, null, 1),
	(207, 'No', 2, 2, 174.99, null, 1),
	(208, 'Yes', 2, 2, 149.99, null, 1),
	(301, 'No', 2, 4, 199.99, 10.0, 2),
	(302, 'Yes', 2, 4, 174.99, 10.0, 2),
	(303, 'No', 2, 4, 199.99, 10.0, 2),
	(304, 'Yes', 2, 4, 174.99, 10.0, 2),
	(305, 'No', 2, 2, 174.99, null, 1),
	(306, 'Yes', 2, 2, 149.99, null, 1),
	(307, 'No', 2, 2, 174.99, null, 1),
	(308, 'Yes', 2, 2, 149.99, null, 1),
	(401, 'Yes', 3, 8, 399.99, 20.0, 3),
	(402, 'Yes', 3, 8, 399.99, 20.0, 3);

INSERT INTO Guest (guestName, address, city, state, zip, phone) VALUES
	('Blessing Aliu',	'Land of Ever After',	'Londres', 'QB', '75930', '(321) 901-2034'),
	('Mack Simmer',	'379 Old Shore Street',	'Council Bluffs', 'IA',	'51501', '(291) 553-0508'),
	('Bettyann Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK',	'99654', '(478) 277-9632'),
	('Duane Cullison', '9662 Foxrun Lane', 'Harlingen', 'TX', '78552', '(308) 494-0198'),
	('Karie Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '(214) 730-0298'),
	('Aurore Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601', '(377) 507-0974'),
	('Zachery Luechtefeld',	'7 Poplar Dr.',	'Arvada', 'CO',	'80003', '(814) 485-2615'),
	('Jeremiah Pendergrass', '70 Oakwood St.', 'Zion', 'IL', '60099', '(279) 491-0960'),
	('Walter Holaway',	'7556 Arrowhead St.', 'Cumberland', 'RI', '02864', '(446) 396-6785'),
	('Wilfred Vise', '77 West Surrey Street', 'Oswego', 'NY', '13126', '(834) 727-1001'),
	('Maritza Tilton', '939 Linda Rd.',	'Burke', 'VA',	'22015', '(446) 351-6860'),
	('Joleen Tison', '87 Queen St.', 'Drexel Hill', 'PA', '19026', '(231) 893-2755');
    
INSERT INTO reservation (guestName, adults, children, startDate, endDate, totalRoomCost, roomId, guestId) VALUES 
	('Mack Simmer', 1, 0, '2023-2-2', '2023-2-4', 299.98, 16, 2),
	('Bettyann Seery', 2, 1, '2023-2-5', '2023-2-10', 999.95, 3, 3),
	('Duane Cullison', 2, 0, '2023-2-22', '2023-2-24', 349.98, 13, 4),
	('Karie Yang', 2, 2, '2023-3-6', '2023-3-7', 199.99, 1, 5),
	('Blessing Aliu', 1, 1, '2023-3-17', '2023-3-20', 524.97, 15, 1),
	('Aurore Lipton', 3, 0, '2023-3-18', '2023-3-23', 924.95, 10, 6),
	('Zachery Luechtefeld', 2, 2, '2023-3-29', '2023-3-31', 349.98, 2, 7),
	('Jeremiah Pendergrass', 2, 0, '2023-3-31', '2023-4-5', 874.95, 12, 8),
	('Walter Holaway', 1, 0, '2023-4-9', '2023-4-13', 799.96, 9, 9),
	('Wilfred Vise', 1, 1, '2023-4-23', '2023-4-24', 174.99, 7, 10),
	('Maritza Tilton', 2, 4, '2023-5-30', '2023-6-2', 1199.97, 17, 11),
	('Joleen Tison', 2, 0, '2023-6-10', '2023-6-14', 599.96, 6, 12),
	('Joleen Tison', 1, 0, '2023-6-10', '2023-6-14', 599.96, 8, 12),
	('Aurore Lipton', 3, 0, '2023-6-17', '2023-6-18', 184.99, 12, 6),
	('Blessing Aliu', 2, 0, '2023-6-28', '2023-7-2', 699.96, 5, 1),
	('Walter Holaway', 3, 1, '2023-7-13', '2023-7-14', 184.99, 4, 9),
	('Wilfred Vise', 4, 2, '2023-7-18', '2023-7-21', 1259.97, 17, 10),
	('Bettyann Seery', 2, 1, '2023-7-28', '2023-7-29', 199.99, 11, 3),
	('Bettyann Seery', 1, 0, '2023-8-30', '2023-9-1', 349.98, 13, 3),
	('Mack Simmer', 2, 0, '2023-9-16', '2023-9-17', 149.99, 8, 2),
	('Karie Yang', 2, 2, '2023-9-13', '2023-9-15', 399.98, 3, 5),
	('Duane Cullison', 2, 2, '2023-11-22', '2023-11-25', 1199.97, 17, 4),
	('Mack Simmer', 2, 0, '2023-11-22', '2023-11-25', 449.97, 6, 2),
	('Mack Simmer', 2, 2, '2023-11-22', '2023-11-25', 599.97, 9, 2),
	('Maritza Tilton', 2, 0, '2023-12-24', '2023-12-28', 699.96, 10, 11);


INSERT INTO roomAmenity (roomID, amenityID) VALUES
	(1, 1),
	(1, 2),
	(2, 3),
	(3, 1),
	(3, 2),
	(4, 3),
	(5, 1),
	(5, 3),
	(5, 2),
	(6, 1),
	(6, 3),
	(7, 1),
	(7, 3),
	(7, 2),
	(8, 1),
	(8, 3),
	(9, 1),
	(9, 2),
	(10, 3),
	(11, 1),
	(11, 2),
	(12, 3),
	(13, 1),
	(13, 3),
	(13, 2),
	(14, 1),
	(14, 3),
	(15, 1),
	(15, 3),
	(15, 2),
	(16, 1),
	(16, 3),
	(17, 1),
	(17, 3),
	(17, 4),
	(18, 1),
	(18, 3),
	(18, 4);


SELECT * FROM Guest
WHERE guestName = 'Jeremiah Pendergrass';

DELETE FROM Reservation
WHERE guestID = 8;

DELETE FROM Guest
WHERE guestID = 8;