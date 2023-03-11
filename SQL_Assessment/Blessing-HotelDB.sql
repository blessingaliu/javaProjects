DROP DATABASE IF EXISTS BlessingHotel;

CREATE DATABASE BlessingHotel;

USE BlessingHotel;

CREATE TABLE Guest (
    guestID INT PRIMARY KEY AUTO_INCREMENT,
    guestName VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(5) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE Amenity (
	amenityID INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(40) NOT NULL
);

CREATE TABLE RoomType (
	roomTypeID INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(40) NOT NULL
);

CREATE TABLE Room (
	roomID INT PRIMARY KEY AUTO_INCREMENT,
    roomNumber INT NOT NULL,
    adaAccessible VARCHAR(5) NOT NULL,
    standardOccupancy INT NOT NULL,
    maximumOccupancy INT NOT NULL,
    basePrice DOUBLE NOT NULL,
    extraPerson DOUBLE,
    roomTypeID INT NOT NULL
);

CREATE TABLE Reservation (
    reservationID INT PRIMARY KEY AUTO_INCREMENT,
    guestName VARCHAR(50) NOT NULL,
    adults INT NOT NULL,
    children INT NOT NULL,
    startDate TIMESTAMP NOT NULL,
    endDate TIMESTAMP NOT NULL,
    totalRoomCost DOUBLE NOT NULL,
    roomID INT NOT NULL,
    guestID INT NOT NULL,
    CONSTRAINT fk_Reservation_Room
        FOREIGN KEY (roomID) 
        REFERENCES Room(roomID),
	CONSTRAINT fk_Guest_Reservation
        FOREIGN KEY (guestID) 
        REFERENCES Guest(guestID)
);

CREATE TABLE RoomAmenity (
	roomID INT NOT NULL,
    amenityID INT NOT NULL,
    PRIMARY KEY pk_RoomAmenity (roomID, amenityID),
    FOREIGN KEY fk_RoomAmenity_Room (roomID)
		REFERENCES Room(roomID),
	FOREIGN KEY fk_RoomAmenity_Amenity (amenityID)
		REFERENCES Amenity(amenityID)
);