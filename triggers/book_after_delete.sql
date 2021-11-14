CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`book_AFTER_DELETE` AFTER DELETE ON `book` FOR EACH ROW
BEGIN
	DECLARE id_value_1 INT;
    DECLARE id_value_2 INT;
    
	SELECT count(book_id) INTO id_value_1 
    FROM user_marked_book 
    WHERE user_marked_book.book_id = old.id;
    
    SELECT count(book_id) INTO id_value_2 
    FROM reference 
    WHERE reference.book_id = old.id;
    
	IF id_value_1 > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DELETE Error (Foreign key in user_marked_book).';
	END IF;
	IF id_value_2 > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DELETE Error (Foreign key in reference).';    
    END IF;
END