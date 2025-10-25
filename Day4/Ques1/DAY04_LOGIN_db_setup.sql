-- Create database and users table for login example
CREATE DATABASE IF NOT EXISTS day04db;
USE day04db;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  loginid VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL
);

-- sample user: loginid: alice password: pass123
INSERT INTO users (loginid, password, name) VALUES ('alice', 'pass123', 'Alice');
