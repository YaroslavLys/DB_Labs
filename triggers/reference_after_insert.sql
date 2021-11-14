CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`reference_AFTER_INSERT` AFTER INSERT ON `reference` FOR EACH ROW
BEGIN
	DECLARE id_value INT;
    
	SELECT COUNT(id) INTO id_value 
    FROM book 
    WHERE book.id = new.id;
    
	IF id_value = 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'INSERT Error (No book for this reference).';
    END IF;
END
