/* Author: 14323808 */

CREATE TABLE PAYMENTS (
PAYMENTID       INTEGER     NOT NULL 
                            PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                            (START WITH 1, INCREMENT BY 1),
USEREMAIL       VARCHAR(20) NOT NULL,
CARDNO          VARCHAR(20) NOT NULL,
CARDCVV         VARCHAR(3) NOT NULL,
CARDNAME        VARCHAR(20) DEFAULT current_date NOT NULL
);

INSERT INTO payments (userEmail, cardNo, cardCVV, cardName) VALUES ('clare@gmail.com','3045 6789 2367','199', 'Clare L. Smith');
INSERT INTO payments (userEmail, cardNo, cardCVV, cardName) VALUES ('tom@gmail.com','9023 4392 2103','487', 'Tom E. Anders');
