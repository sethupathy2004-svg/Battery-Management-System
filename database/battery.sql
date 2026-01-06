CREATE DATABASE battery_db;

USE battery_db;

CREATE TABLE battery (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    voltage DOUBLE,
    rated_voltage DOUBLE,
    soc DOUBLE
);
