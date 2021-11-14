CREATE FUNCTION `info_about_user` (
user_id INT
)
RETURNS VARCHAR(100) CHARSET latin1
BEGIN
RETURN (
SELECT CONCAT(SUBSTRING(name,1,1),SUBSTRING(surname,1,1),SUBSTRING(middle_name,1,1)) AS user_nsm 
FROM user 
WHERE id=user_id
);
END
