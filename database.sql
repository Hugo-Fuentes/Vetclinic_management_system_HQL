DROP DATABASE IF EXISTS VetClinic;

CREATE DATABASE VetClinic;

USE VetClinic;

CREATE TABLE VetClinic.Pet(
    petId int AUTO_INCREMENT,
    name varchar(80) NOT NULL,
    clientId int,
    PRIMARY KEY(petId)
);

CREATE TABLE VetClinic.Client(
    clientId int AUTO_INCREMENT,
    name varchar(80) NOT NULL,
    lastName varchar(100) NOT NULL,
    dni char(9),
    phoneNumber char(9),
    PRIMARY KEY(clientId)
);

CREATE TABLE VetClinic.Veterinarian(
    veterinarianId int AUTO_INCREMENT,
    name varchar(80) NOT NULL,
    speciality varchar(40) NOT NULL,
    lastName varchar(100) NOT NULL,
    phoneNumber char(9),
    PRIMARY KEY(veterinarianId)
);

CREATE TABLE VetClinic.Appointment(
    petId int,
    veterinarianId int,
    date date NOT NULL,
    time time NOT NULL,
    reason text NOT NULL
);

ALTER TABLE Pet 
ADD CONSTRAINT fk_pet_client 
FOREIGN KEY (clientId) 
REFERENCES Client(clientid);

ALTER TABLE Appointment 
ADD CONSTRAINT fk_appointment_pet 
FOREIGN KEY (petId) 
REFERENCES Pet(petId);

ALTER TABLE Appointment 
ADD CONSTRAINT fk_appointment_veterinarian 
FOREIGN KEY (veterinarianId) 
REFERENCES Veterinarian(veterinarianId);


INSERT INTO Client (clientId, name, lastName, dni, phoneNumber) VALUES
(1, 'Carlos', 'Garcia Lopez', '12345678A', '612345678'),
(2, 'Laura', 'Martinez Perez', '23456789B', '623456789'),
(3, 'Miguel', 'Fernandez Ruiz', '34567890C', '634567890'),
(4, 'Ana', 'Rodriguez Diaz', '45678901D', '645678901'),
(5, 'Pablo', 'Sanchez Torres', '56789012E', '656789012');




INSERT INTO Pet (petId, name, clientId) VALUES
(1, 'Max', 1),
(2, 'Luna', 2),
(3, 'Rocky', 3),
(4, 'Nala', 4),
(5, 'Toby', 5);




INSERT INTO Veterinarian (veterinarianId, name, speciality, lastName, phoneNumber) VALUES
(1, 'Antonio', 'Dogs', 'Lopez Martin', '611111111'),
(2, 'Maria', 'Cats', 'Garcia Perez', '622222222'),
(3, 'David', 'Horses', 'Fernandez Ruiz', '633333333'),
(4, 'Elena', 'Dogs', 'Sanchez Diaz', '644444444'),
(5, 'Javier', 'cats', 'Martinez Torres', '655555555');




INSERT INTO Appointment (petId, veterinarianId, date, time, reason) VALUES
(1, 1, '2026-11-20', '10:00:00', 'Skin examination'),
(2, 2, '2026-11-20', '11:30:00', 'Routine surgery checkup'),
(3, 3, '2026-11-21', '09:00:00', 'Heart examination'),
(4, 4, '2026-11-21', '12:00:00', 'Dental cleaning'),
(5, 5, '2026-11-22', '16:30:00', 'Eye examination');

