CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`book_AFTER_INSERT` AFTER INSERT ON `book` FOR EACH ROW
BEGIN
	DECLARE id_value INT;
    
	SELECT COUNT(id) INTO id_value 
    FROM directory_tree
    WHERE directory_tree.id = new.directory_tree_id;
    
	IF id_value = 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'INSERT Error (No directory for this book).';
    END IF;
END