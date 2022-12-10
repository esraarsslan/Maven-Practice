--1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
CREATE TABLE companies 
(  
  company_id SMALLINT, 
  company VARCHAR(20),
  number_of_employees SMALLINT
);

INSERT INTO companies VALUES(100, 'IBM', 12000);
INSERT INTO companies VALUES(101, 'GOOGLE', 18000);
INSERT INTO companies VALUES(102, 'MICROSOFT', 10000);
INSERT INTO companies VALUES(103, 'APPLE', 21000);

SELECT * FROM companies;
--1.YOL****
SELECT company, number_of_employees
FROM companies
ORDER BY number_of_employees DESC

--2. YOLL****

SELECT company, number_of_employees
FROM companies
WHERE number_of_employees = 18000;

Select * from companies;
