MySQL Query:

CREATE DATABASE coderhouse;
USE coderhouse;
select * from clients ;
ALTER TABLE clients RENAME COLUMN client_address TO clientAddress;
ALTER TABLE clients RENAME COLUMN client_email TO clientEmail;
ALTER TABLE clients RENAME COLUMN client_phone TO clientPhone;
SELECT * FROM clients WHERE dni = 20000099;
SELECT * FROM products;
