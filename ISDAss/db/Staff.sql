/* Author: 14323808 */

CREATE TABLE STAFF (
STAFFEMAIL       VARCHAR(20) NOT NULL PRIMARY KEY,
STAFFNAME        VARCHAR(20) NOT NULL,
STAFFPOSITION    VARCHAR(20) NOT NULL,
STAFFADDRESS     VARCHAR(40) NOT NULL,
STAFFSTATUS      VARCHAR(20) NOT NULL
);

INSERT INTO staff (staffEmail, staffName, staffPosition, staffAddress, staffstatus) VALUES ('john@iot.com','John Doe','System Admin','100 Charming Avenue, Sydney, NSW','Active');
INSERT INTO staff (staffEmail, staffName, staffPosition, staffAddress, staffstatus) VALUES ('ben@iot.com','Ben Wilson','HR','18 Sydney Street, Sydney, NSW','Active');
INSERT INTO staff (staffEmail, staffName, staffPosition, staffAddress, staffstatus) VALUES ('heather@iot.com','Heather Smith','System Admin','5 Parliament Road, Sydney, NSW','Active');