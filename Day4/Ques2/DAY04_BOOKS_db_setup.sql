CREATE DATABASE IF NOT EXISTS day04books;
USE day04books;
CREATE TABLE IF NOT EXISTS books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  author VARCHAR(200) NOT NULL,
  price DOUBLE NOT NULL
);
INSERT INTO books (title, author, price) VALUES ('Java Basics', 'Author A', 299.0);
