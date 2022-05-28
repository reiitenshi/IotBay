/* Author: 14323808 */

CREATE TABLE DEVICES (
DEVICEID    INTEGER     NOT NULL 
                        PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                        (START WITH 1, INCREMENT BY 1),
DEVICENAME  VARCHAR(30) NOT NULL,
UNITPRICE   FLOAT       NOT NULL,
DEVICESTOCK INTEGER     NOT NULL,
DEVICETYPE  VARCHAR(30),
DEVICEBRAND VARCHAR(20)
);

INSERT INTO devices (deviceName, unitPrice, deviceStock, DeviceType, deviceBrand) VALUES ('Samsung A5 64GB', 219.99, 500, 'Mobile Phone', 'Samsung');
INSERT INTO devices (deviceName, unitPrice, deviceStock, DeviceType, deviceBrand) VALUES ('TLC OLED 4K 60"', 3049.50, 1000, 'Television', 'TLC');
INSERT INTO devices (deviceName, unitPrice, deviceStock, DeviceType, deviceBrand) VALUES ('iPhone 13 Pro 256GB', 2499.99, 750, 'Mobile Phone', 'Apple');
INSERT INTO devices (deviceName, unitPrice, deviceStock, DeviceType, deviceBrand) VALUES ('Microsoft Surface 13" 1TB', 2190.00, 400, 'Computer', 'Microsoft');