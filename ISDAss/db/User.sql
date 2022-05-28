/* Author: 14323808 */

CREATE TABLE USER (
    USEREMAIL           VARCHAR(30) NOT NULL PRIMARY KEY,
    USERPASSWORD        VARCHAR(20) NOT NULL,
    USERFNAME           VARCHAR(15) NOT NULL,
    USERLNAME           VARCHAR(15) NOT NULL,
    USERADDRESS         VARCHAR(40) NOT NULL
);

INSERT INTO users (userEmail, userPassword, userFName, userLName, userAddress) VALUES ('john@iot.com','password1','John','Doe','100 Charming Avenue, Sydney, NSW');
INSERT INTO users (userEmail, userPassword, userFName, userLName, userAddress) VALUES ('ben@iot.com','admin','Ben','Wilson','18 Sydney Street, Sydney, NSW');
INSERT INTO users (userEmail, userPassword, userFName, userLName, userAddress) VALUES ('heather@iot.com','wordpass1','Heather','Smith','5 Parliament Road, Sydney, NSW');
INSERT INTO users (userEmail, userPassword, userFName, userLName, userAddress) VALUES ('clare@gmail.com','dogname2','Clare','Smith','20 Big Road, Sydney, NSW');
INSERT INTO users (userEmail, userPassword, userFName, userLName, userAddress) VALUES ('tom@gmail.com','cat123','Tom','Anders','2 Little Street, Sydney, NSW');
