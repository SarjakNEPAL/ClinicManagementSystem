create database ClinicManagementSystem;
USE ClinicManagementSystem;
CREATE TABLE Staff (
    ID INT(10),
    Name VARCHAR(255),
    Type VARCHAR(10),
    Password VARCHAR(16)
);

CREATE TABLE Patient (
    Name VARCHAR(255),
    Address VARCHAR(255),
    PhoneNumber INT CHECK(LENGTH(PhoneNumber) = 10),
    Gender VARCHAR(10)
);

CREATE TABLE Appointment (
    PatientPhone INT REFERENCES Patient(PhoneNumber),
    Date DATE,
    Time TIME,
    Doctor VARCHAR(255),
    StaffID INT REFERENCES Staff(ID)
);
