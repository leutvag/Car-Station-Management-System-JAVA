CREATE TABLE users(id NUMBER GENERATED ALWAYS AS IDENTITY,username VARCHAR2(15) not NULL, password VARCHAR2(50), PRIMARY KEY (id));
CREATE TABLE gas_prices( id_gas NUMBER ,name_gas VARCHAR2(50), price_gas NUMBER(3,2) , PRIMARY KEY (id_gas));
CREATE TABLE gas( idg NUMBER GENERATED ALWAYS AS IDENTITY ,nameg VARCHAR2(50), priceg NUMBER(4,2), id NUMBER , PRIMARY KEY (idg), FOREIGN KEY(id) REFERENCES users(id));
CREATE TABLE parking( idp NUMBER GENERATED ALWAYS AS IDENTITY ,namep VARCHAR2(50), pricep NUMBER(10,2), id NUMBER , PRIMARY KEY (idp), FOREIGN KEY(id) REFERENCES users(id));
CREATE TABLE maintenance( part_code NUMBER, namem VARCHAR2(50), pricem NUMBER(5,2),quantity NUMBER, PRIMARY KEY (part_code));
CREATE TABLE maintenance_total_price( p_code NUMBER GENERATED ALWAYS AS IDENTITY, namem VARCHAR2(50), pricem NUMBER(6,2),id NUMBER, PRIMARY KEY (p_code),FOREIGN KEY(id) REFERENCES users(id));
CREATE TABLE staff(id_staff NUMBER ,username_staff VARCHAR2(15) not NULL, password_staff VARCHAR(50), PRIMARY KEY(id_staff));
CREATE TABLE contact(id NUMBER, dm VARCHAR(150),PRIMARY KEY (id), FOREIGN KEY(id) REFERENCES users(id));
CREATE TABLE cars(id NUMBER, sign_car VARCHAR2(15),name VARCHAR2(30),date_car VARCHAR2(50),PRIMARY KEY (id), FOREIGN KEY(id) REFERENCES users(id));

SELECT part_code, namem, pricem FROM maintenance;

drop table cars;
drop table gas;
drop table parking;
drop table maintenance;
drop table gas_prices;
drop table users;
drop table staff;

commit;


INSERT INTO staff(id_staff ,username_staff, password_staff)
VALUES (1,'1234','123');
INSERT INTO staff(id_staff ,username_staff, password_staff)
VALUES (2,'1233','123');
INSERT INTO staff(id_staff ,username_staff, password_staff)
VALUES (3,'1235','123');
INSERT INTO staff(id_staff ,username_staff, password_staff)
VALUES (4,'1236','123');





INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (1,'ΛΑΔΙΑ',150, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (2,'ΛΑΣΤΙΧΑ',150, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (3,'ΠΡΟΦΥΛΑΚΤΗΡΕΣ',50, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (4,'ΕΞΑΤΜΙΣΗ',30, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (5,'ΚΑΘΡΕΦΤΕΣ',45, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (6,'ΦΙΛΤΡΟ ΛΑΔΙΟΥ',60, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (7,'ΦΡΕΝΑ',100, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (8,'ΖΑΝΤΕΣ',400, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (9,'ΥΓΡΑ ΦΡΕΝΩΝ',50, 50);
INSERT INTO maintenance(part_code ,namem, pricem, quantity)
VALUES (10,'ΥΓΡΑ ΨΥΓΕΙΟΥ',35, 50);




INSERT INTO gas_prices(id_gas ,name_gas, price_gas)
VALUES (1,'ΠΕΤΡΕΛΑΙΟ',1.4);
INSERT INTO gas_prices(id_gas ,name_gas, price_gas)
VALUES (2,'ΑΕΡΙΟ',1.1);
INSERT INTO gas_prices(id_gas ,name_gas, price_gas)
VALUES (3,'ΒΑΝΖΙΝΗ ΑΠΛΗ',1.6);
INSERT INTO gas_prices(id_gas ,name_gas, price_gas)
VALUES (4,'ΒΕΝΖΙΝΗ ΣΟΥΠΕΡ',1.9);


