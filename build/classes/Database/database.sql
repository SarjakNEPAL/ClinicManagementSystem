-- Create the user "Clinic" with password "Clinic"
CREATE USER 'Clinic'@'localhost' IDENTIFIED BY 'Clinic';

-- Grant necessary privileges to the user
GRANT ALL PRIVILEGES ON *.* TO 'Clinic'@'localhost';

-- Create the database "ClinicManagementSystem"
CREATE DATABASE ClinicManagementSystem;

-- Switch to the newly created database
USE ClinicManagementSystem;

-- Create the Staff table
CREATE TABLE Staff (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Type VARCHAR(10),
    Password VARCHAR(200)
);

-- Create the Patient table
CREATE TABLE Patient (
    Name VARCHAR(255),
    Address VARCHAR(255),
    PhoneNumber INT(10),
    Gender VARCHAR(10)
);

-- Create the Appointment table
CREATE TABLE Appointment (
    PatientPhone INT,
    Date DATE,
    Time TIME,
    Doctor VARCHAR(255),
    StaffID INT,
    FOREIGN KEY (PatientPhone) REFERENCES Patient(PhoneNumber),
    FOREIGN KEY (StaffID) REFERENCES Staff(ID)
);

-- Insert a sample staff record (remember to hash the password securely)
INSERT INTO Staff (ID, Name, Type, Password)
VALUES (1234, 'admin', 'owner', 'hZp9RUu4ckO5337OrZEyPg==');
