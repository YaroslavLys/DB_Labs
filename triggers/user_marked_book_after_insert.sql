CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`user_marked_book_AFTER_INSERT` AFTER INSERT ON `user_marked_book` FOR EACH ROW
BEGIN
	DECLARE id_value_1 INT;
    DECLARE id_value_2 INT;
    
	SELECT COUNT(id) INTO id_value_1 
    FROM book 
    WHERE book.id = new.book_id;
    
    SELECT COUNT(id) INTO id_value_2 
    FROM user 
    WHERE user.id = new.user_id;
    
	IF id_value_1 = 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'INSERT Error (No book for this user).';
    END IF;
	IF id_value_2 = 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'INSERT Error (No user for this book).';
    END IF;
END
