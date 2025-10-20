CREATE DATABASE userdb;

USE userdb;

CREATE TABLE Users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  userid VARCHAR(50),
  password VARCHAR(100)
);
