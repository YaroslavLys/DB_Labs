CREATE DEFINER=`root`@`localhost` FUNCTION `get_name_and_authors_from_reference`(
reference_id INT
) RETURNS varchar(90) CHARSET latin1
    READS SQL DATA
    DETERMINISTIC
BEGIN
RETURN (
SELECT CONCAT('"',name,'"'," ",authors) AS book 
FROM reference
JOIN book ON book.id=reference.book_id
WHERE reference_id = reference.id );
END