CREATE PROCEDURE `insertion_into_users` (
IN login VARCHAR(50),
IN surname VARCHAR(50), 
IN name VARCHAR(50),
IN middle_name VARCHAR(50),
IN birth_date DATE,
IN birth_place VARCHAR(60),
IN home_place VARCHAR(60),
IN remark VARCHAR(30),
IN rate INT,
IN password_id INT
)
BEGIN
INSERT INTO user(`login`,`surname` , `name`, `middle_name` ,`birth_date` , `birth_place`, `home_place`, `remark`, `rate`, `password_id`) VALUES
(login, surname , name, middle_name , birth_date , birth_place, home_place, remark, rate, password_id);
END
