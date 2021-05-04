DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Transactions;

CREATE TABLE Users (
userId INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR (50),
address VARCHAR (255)
);

CREATE table Accounts (
acoountId INTEGER PRIMARY KEY AUTOINCREMENT,
userId INTEGER(10) NOT NULL,
balance INTEGER(15),
currency VARCHAR(10),
FOREIGN KEY (userId) REFERENCES Users (userId)
);

CREATE TABLE Transactions (
transactinId INTEGER PRIMARY KEY AUTOINCREMENT,
accountId INTEGER (10),
amount INTEGER (15),
FOREIGN KEY (accountId) REFERENCES Accounts (accountId)
);

INSERT INTO Users (name, address) VALUES ("name", "address");

select * from users;

select * from Accounts;

select * from Transactions;