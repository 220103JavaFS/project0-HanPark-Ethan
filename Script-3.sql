--CREATE DATABASE project0;

CREATE TABLE roles(
	role_name VARCHAR(30) PRIMARY KEY,
	min_salary NUMERIC(10, 2),
	max_salary NUMERIC(10, 2)
);

CREATE TABLE departments(
	dept_name VARCHAR(30) PRIMARY KEY,
	dept_descr VARCHAR(50)
);

CREATE TABLE login(
	login_username VARCHAR(20) PRIMARY KEY,
	login_password VARCHAR(20)
);

CREATE TABLE users(
	user_id SERIAL PRIMARY KEY,
	first_name	VARCHAR(30),
	last_name VARCHAR(30),
	username VARCHAR(20) NOT NULL REFERENCES login(login_username),
	user_email VARCHAR(50),
	user_phone VARCHAR(20),
	user_dob VARCHAR(10),
	dept_names VARCHAR(30) REFERENCES departments(dept_name),
	role_names VARCHAR(30) NOT NULL REFERENCES roles(role_name),
	salary NUMERIC(10, 2)
);

INSERT INTO roles (role_name, min_salary, max_salary)
	VALUES ('Intern', '30000.00', '40000.00'),
	('Associate', '45000.00', '55000.00'),
	('Manager', '70000.00', '80000.00');

INSERT INTO departments(dept_name, dept_descr)
	VALUES ('Recruiter', 'Recruit'),
	('DevOp', 'Development Operation'),
	('HR', 'Human Resources');

INSERT INTO login(login_username, login_password)
	VALUES ('han.park', 'MyNameIsHan'),
	('jeong.kim', 'MyNameIsJeong'),
	('mike.ludwig', 'MyNameIsMike'),
	('jeremiah.weaver', 'MyNameIsJeremiah'),
	('jae.lewis', 'MyNameIsJae');

INSERT INTO users(first_name, last_name, username, user_email, user_phone, user_dob, dept_names, role_names, salary)
	VALUES ('han', 'park', 'han.park', 'abc@abc.com','703-123-4567', '01-11-1989', 'DevOp', 'Intern', 30000),
	('jeong', 'kim', 'jeong.kim', 'bcd@abc.com', '703-321-6543', '05-20-1990', 'DevOp', 'Associate', 50000.00),
	('mike', 'ludwig', 'mike.ludwig', 'sdf@abc.com', '571-345-6788', '02-21-1988', 'DevOp', 'Associate', 50000.00),
	('jeremiah', 'weaver', 'jeremiah.weaver', 'cnsjk@abc.com', '703-123-7642', '04-02-1980', 'HR', 'Manager', 80000),
	('jae', 'lewis', 'jae.lewis', 'hkl@abc.com', '571-645-1273', '12-31-1987', 'Recruiter', 'Manager', 75000.00);
	
SELECT * FROM (SELECT * FROM users FULL OUTER JOIN roles ON users.role_names = roles.role_name)
	AS role_name CHECK salary > min_salary OR salary < max_salary;



DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS departments;