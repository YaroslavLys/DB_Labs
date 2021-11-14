CREATE PROCEDURE `selection_from_user_marked_book` (
IN book_name VARCHAR(45)
)
BEGIN
IF book_name ="" 
THEN
 SELECT login , book.name 
 FROM user_marked_book
 JOIN user ON user.id=user_marked_book.user_id
 JOIN book ON book.id=user_marked_book.book_id;
ELSE
 SELECT login , book.name 
 FROM user_marked_book
 JOIN user ON user.id=user_marked_book.user_id
 JOIN book ON book.id=user_marked_book.book_id
 WHERE book.name = book_name or book.name LIKE CONCAT("%",book_name,"%");
END IF;
END
