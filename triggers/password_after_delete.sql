CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`password_AFTER_DELETE` AFTER DELETE ON `password` FOR EACH ROW
BEGIN
	DECLARE id_value INT;
    
	SELECT COUNT(password_id) INTO id_value 
    FROM user 
    WHERE user.password_id = old.id;
    
	IF id_value > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DELETE Error (Foreign key in user).';
    END IF;
END