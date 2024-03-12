DROP database IF EXISTS library_management_system;
CREATE database IF NOT EXISTS library_management_system;

USE library_management_system;

CREATE TABLE user
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(6) NOT NULL
);


CREATE TABLE admin_user
(
    User_ID   VARCHAR(5) PRIMARY KEY,
    User_Name VARCHAR(25) NOT NULL,
    Password   VARCHAR(12)  NOT NULL,
    First_Name   VARCHAR(25),
    Second_Name  VARCHAR(25)


);

CREATE TABLE book
(
    Book_ID VARCHAR(5) PRIMARY KEY,
    Title VARCHAR(25) NOT NULL,
    Author   VARCHAR(25),
    ISBN VARCHAR(25),
    Available_Copies VARCHAR(5) NOT NULL
);


CREATE TABLE branch
(
    Branch_ID VARCHAR(5) PRIMARY KEY,
    Branch_Name    VARCHAR(25) NOT NULL,
    Address        VARCHAR(25),
    City           VARCHAR(10),
    Phone_Number   VARCHAR(10),
    Status         VARCHAR(25)

);


CREATE TABLE issued_book
(
    Issued_Book_Id VARCHAR(5) PRIMARY KEY,
    Book_ID VARCHAR(5),
    User_ID VARCHAR(5),
    Status VARCHAR(15),
    Fine_Amount DOUBLE(5,2),
    Return_Date DATE,
    Issue_Date DATE,
    Due_Date DATE,
    FOREIGN KEY (Book_ID) REFERENCES book (Book_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (User_ID) REFERENCES admin_user (User_ID) ON DELETE CASCADE ON UPDATE CASCADE

);


CREATE TABLE user_history
(
    Card_No VARCHAR(5) PRIMARY KEY,
    Title VARCHAR(25),
    ISBN VARCHAR(25),
    Date_Borrowed DATE,
    Due_Date DATE,
    Status VARCHAR(25)
);


CREATE TABLE borrowed_books
(
    Card_No VARCHAR(5) PRIMARY KEY,
    Title VARCHAR(25),
    ISBN VARCHAR(25),
    Date_Borrowed DATE,
    Due_Date DATE,
    Status VARCHAR(25)

);

CREATE TABLE login_details
(
    username VARCHAR(20) ,
    User_ID VARCHAR(5),
    FOREIGN KEY (username) REFERENCES user (username) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (User_ID) REFERENCES admin_user (User_ID) ON DELETE CASCADE ON UPDATE CASCADE
);

