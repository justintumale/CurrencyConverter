CREATE TABLE currency (
       id INT NOT NULL AUTO_INCREMENT,
       currsymbol VARCHAR(5) NOT NULL,
       currname VARCHAR(55) NOT NULL,
       dollarvalue DOUBLE FLOAT(10, 5) NOT NULL,
       PRIMARY KEY ( id )
)