DROP DATABASE IF EXISTS companyDB;
CREATE DATABASE companyDB;
USE companyDB;
CREATE TABLE Employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    dept_id INT NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    joining_date DATE NOT NULL
);

INSERT INTO Employee (emp_name, dept_id, salary, joining_date) VALUES
('Alice', 1, 50000, '2022-01-10'),
('Bob', 1, 60000, '2022-03-15'),
('Charlie', 1, 55000, '2022-05-20'),
('David', 1, 70000, '2022-07-25'),
('Eva', 1, 65000, '2022-09-01'),
('Frank', 2, 48000, '2022-02-10'),
('Grace', 2, 52000, '2022-04-12'),
('Helen', 2, 51000, '2022-06-18'),
('Ian', 2, 55000, '2022-08-22'),
('Jack', 2, 50000, '2022-10-05');

SELECT emp_id, emp_name, dept_id, salary
FROM (
    SELECT *,
           ROW_NUMBER() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS rn
    FROM Employee
) AS ranked_emp
WHERE rn <= 5;

DELIMITER $$

CREATE FUNCTION getWorkingDays(joinDate DATE) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE totalDays INT;
    SET totalDays = DATEDIFF(CURDATE(), joinDate);
    RETURN totalDays;
END$$

DELIMITER ;

SELECT emp_name, joining_date, getWorkingDays(joining_date) AS working_days
FROM Employee;


DELIMITER $$

CREATE PROCEDURE updateSalary(IN empId INT)
BEGIN
    DECLARE workDays INT;
    DECLARE newSalary DECIMAL(10,2);
       -- Get working days
    SELECT getWorkingDays(joining_date) INTO workDays
    FROM Employee
    WHERE emp_id = empId;

    -- Get current salary
    SELECT salary INTO newSalary FROM Employee WHERE emp_id = empId;

    -- Update salary based on working days
    IF workDays < 365 THEN
        SET newSalary = newSalary * 1.05;   -- 5% increase
    ELSEIF workDays < 730 THEN
        SET newSalary = newSalary * 1.10;   -- 10% increase
    ELSE
        SET newSalary = newSalary * 1.15;   -- 15% increase
    END IF;

    -- Update table
    UPDATE Employee
    SET salary = newSalary
    WHERE emp_id = empId;
END$$

DELIMITER ;

-- Test the procedure
-- Before update
SELECT * FROM Employee WHERE emp_id = 1;

-- Update salary
CALL updateSalary(1);

-- After update
SELECT * FROM Employee WHERE emp_id = 1;


