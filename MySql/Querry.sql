SELECT * FROM finalproject.category;

UPDATE FinalProject.category SET idCategory=3,nameCategory='Phone' WHERE idCategory=0;
DELETE FROM  FinalProject.category WHERE idCategory=2;

SELECT * FROM FinalProject.category WHERE idCategory = 3

USE FinalProject

CREATE TABLE Product 
(
	idProduct INT PRIMARY KEY,
    nameProduct NVARCHAR(50),
	quantityProduct INT,
	priceProduct INT,
    idCategory INT,
    FOREIGN KEY (idCategory) REFERENCES category(idCategory)
)

ALTER TABLE FinalProject.Category ADD 
PRIMARY KEY (idCategory)

SELECT * FROM Product;
SELECT * FROM finalproject.category;

INSERT INTO FinalProject.Product 
VALUES (
	1,
    'Phone',
    5,
    1000,
    4
)

UPDATE FinalProject.Product SET idProduct = 2, nameProduct = 'Monitor', quantityProduct = 3, priceProduct = 50, idCategory = 4
WHERE idProduct = 10

DELETE FROM FinalProject.Product WHERE idProduct = 7
SELECT * FROM FinalProject.Product WHERE priceProduct >= 60 AND priceProduct <= 1000

CREATE TABLE FinalProject.Bill
(
	idBill INT PRIMARY KEY,
    idProduct INT,
    FOREIGN KEY (idProduct) REFERENCES FinalProject.Product(idProduct),
    quantityBill INT,
    priceBill INT,
    buyDateBill DATE
)

SELECT * FROM Bill
INSERT INTO FinalProject.Bill VALUES (4,4,5,10,'2022-04-25')
TRUNCATE TABLE Bill

SELECT * FROM FinalProject.Bill 
WHERE buyDateBill BETWEEN '2010-01-01' AND '2021-01-01'