CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`user_AFTER_DELETE` AFTER DELETE ON `user` FOR EACH ROW
BEGIN
	DECLARE id_value INT;
    DECLARE number_of_users_value INT;
    
	SELECT COUNT(user_id) INTO id_value 
    FROM user_marked_book 
    WHERE user_marked_book.user_id = old.id;
    
    SELECT COUNT(*) INTO number_of_users_value 
    FROM user;
    
	IF id_value > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DELETE Error (Foreign key in user_marked_book).';
    END IF;
    IF number_of_users_value < 2 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error Cardinality (Should be at least 2 users).';
    END IF;
END