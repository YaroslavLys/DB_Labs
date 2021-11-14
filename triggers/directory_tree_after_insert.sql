CREATE DEFINER = CURRENT_USER TRIGGER `book_db`.`directory_tree_AFTER_INSERT` AFTER INSERT ON `directory_tree` FOR EACH ROW
BEGIN
	DECLARE id_value_1 INT;
    
	SELECT COUNT(id) INTO id_value_1 
    FROM directory_tree 
    WHERE directory_tree.id = new.directory_tree_id;
    
	IF id_value_1 = 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'INSERT Error (No directory for this directory).';
    END IF;
END