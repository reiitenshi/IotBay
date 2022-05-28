/* Author: 14323808 */

CREATE TABLE ORDERS (
ORDERID         INTEGER     NOT NULL 
                            PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                            (START WITH 1, INCREMENT BY 1),
DEVICEID        INTEGER     NOT NULL,
QUANTITY        INTEGER     NOT NULL,
SUBMITTED       BOOLEAN     DEFAULT FALSE NOT NULL,
ORDERDATE       VARCHAR(20) NOT NULL
);

INSERT INTO orders (deviceId, quantity, submitted, orderDate) VALUES (1, 200, false, '25/05/2020');
INSERT INTO orders (deviceId, quantity, submitted, orderDate) VALUES (2, 10, false, '03/09/2019');
INSERT INTO orders (deviceId, quantity, submitted, orderDate) VALUES (3, 11, false, '10/02/2021');