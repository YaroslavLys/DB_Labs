CREATE DATABASE IF NOT EXISTS book_db;
USE book_db;


DROP TABLES IF EXISTS user;				
CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
	middle_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
	birth_place VARCHAR(60) NOT NULL,
    home_place VARCHAR(60) NOT NULL,
    remark VARCHAR(30) NOT NULL,
	rate DOUBLE NOT NULL,
    password_id  INT UNIQUE NOT NULL
);

DROP TABLES IF EXISTS book;
CREATE TABLE book (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
    authors VARCHAR(45) NOT NULL,
    udk_index INT NOT NULL,
    rate DOUBLE NOT NULL,
    directory_tree_id INT NOT NULL
);

DROP TABLES IF EXISTS user_marked_book;
CREATE TABLE user_marked_book (
	id INT AUTO_INCREMENT PRIMARY KEY,
    book_id  INT NOT NULL,
    user_id INT NOT NULL
);

DROP TABLES IF EXISTS password;
CREATE TABLE password (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);

DROP TABLES IF EXISTS reference;
CREATE TABLE reference (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email_address VARCHAR(80) NOT NULL,
    book_id INT NOT NULL
);

DROP TABLES IF EXISTS directory_tree;
CREATE TABLE directory_tree (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rubric VARCHAR(40) NOT NULL,
    directory_tree_id INT NOT NULL
);
