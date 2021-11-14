CREATE DEFINER=`root`@`localhost` TRIGGER `user_AFTER_UPDATE` AFTER UPDATE ON `user` FOR EACH ROW BEGIN
	DECLARE id_value INT;
    DECLARE login_value VARCHAR(45);
    DECLARE rate_value INT;
    
	SELECT COUNT(user_id) INTO id_value 
    FROM user_marked_book 
    WHERE user_marked_book.user_id = old.id
    LIMIT 1;
    SELECT login INTO login_value 
    FROM user 
    WHERE user.login = new.login
    LIMIT 1;
    SELECT rate INTO rate_value 
    FROM user 
    WHERE user.rate= new.rate
    LIMIT 1;
    
    IF new.login  RLIKE "^[0-9].+" THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT Error (login can't start with number).";
	END IF;
	IF length(new.login)<6 THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT Error (login is too short).";
	END IF;
    IF new.rate  NOT BETWEEN 1 AND 10 THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT Error (rate should be between 1 and 10).";
	END IF;
	IF id_value > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'UPDATE Error (Foreign key in user_marked_book).';
    END IF;
END