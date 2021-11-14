CREATE PROCEDURE `cursor` ()
BEGIN
DECLARE first_table  VARCHAR(45);
DECLARE second_table VARCHAR(45);
DECLARE done INT DEFAULT FALSE;
DECLARE id INT;
DECLARE name VARCHAR(45);
DECLARE authors VARCHAR(45);
DECLARE udk_index INT;
DECLARE rate DOUBLE;
DECLARE directory_tree_id INT;
DECLARE BCursor CURSOR
FOR SELECT * 
FROM book;
DECLARE CONTINUE HANDLER
FOR NOT FOUND SET done = TRUE;
	SET first_table = CONCAT("book1-", NOW());
	SET second_table = CONCAT("book2-", NOW());
	SET @temp_query =CONCAT ("Create table `",first_table,"` (
	id int not null PRIMARY KEY,
	name varchar(45) not null,
    authors varchar(45) not null,
    udk_index int not null,
    rate double not null,
    directory_tree_id int not null
);");
PREPARE my_query FROM @temp_query;
EXECUTE my_query;
DEALLOCATE PREPARE my_query;
SET @temp_query =CONCAT ("Create table `",second_table,"` (
    id int not null PRIMARY KEY,
	name varchar(45) not null,
    authors varchar(45) not null,
    udk_index int not null,
    rate double not null,
    directory_tree_id int not null
);");
PREPARE my_query FROM @temp_query;
EXECUTE my_query;
DEALLOCATE PREPARE my_query;

OPEN BCursor;
myLoop: LOOP
	FETCH BCursor INTO id, name, authors, udk_index, rate, directory_tree_id;
	IF done = TRUE THEN LEAVE myLoop;
	END IF;
	SET @rand = RAND();
	IF @rand>0.5 
    THEN 
		BEGIN
			SET @temp_query =CONCAT ("insert into `",first_table,"` VALUES (",id,",'",name,"','",authors,"',",udk_index,",",rate,",",directory_tree_id,");");
			PREPARE my_query FROM @temp_query;
			EXECUTE my_query;
			DEALLOCATE PREPARE my_query;
        END;
	ELSE  
        BEGIN
			SET @temp_query =CONCAT ("insert into `",second_table,"` VALUES (",id,",'",name,"','",authors,"',",udk_index,",",rate,",",directory_tree_id,");");
			PREPARE my_query FROM @temp_query;
			EXECUTE my_query;
			DEALLOCATE PREPARE my_query;
        END;
	END IF	;
END LOOP;
CLOSE BCursor;
END
