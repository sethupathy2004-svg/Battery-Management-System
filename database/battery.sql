CREATE DATABASE battery_management;
USE battery_management;

CREATE TABLE battery (
    battery_id INT AUTO_INCREMENT PRIMARY KEY,
    battery_name VARCHAR(50),
    battery_type VARCHAR(30),
    rated_voltage DOUBLE,
    rated_capacity DOUBLE
);

CREATE TABLE battery_data (
    data_id INT AUTO_INCREMENT PRIMARY KEY,
    battery_id INT,
    voltage DOUBLE,
    current DOUBLE,
    temperature DOUBLE,
    soc DOUBLE,
    timestamp DATETIME,
    FOREIGN KEY (battery_id) REFERENCES battery(battery_id)
);

