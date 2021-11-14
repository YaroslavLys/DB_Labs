CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`directory_tree_AFTER_DELETE` AFTER DELETE ON `directory_tree` FOR EACH ROW
BEGIN
	DECLARE id_value_1 INT;
    DECLARE id_value_2 INT;
    
	SELECT COUNT(directory_tree_id) INTO id_value_1 
    FROM book 
    WHERE book.directory_tree_id = old.id;
    
    SELECT COUNT(directory_tree_id) INTO id_value_2 
    FROM directory_tree 
    WHERE directory_tree.directory_tree_id = old.id;
    
	IF id_value_1 > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DELETE Error (Foreign key in book).';
	END IF;
	if id_value_2 > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DELETE Error (Foreign key in directory tree).';    
    END IF;
END