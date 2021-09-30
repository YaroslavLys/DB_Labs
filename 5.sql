SELECT distinct maker
FROM product
WHERE maker = SOME(SELECT maker FROM product WHERE type = 'Laptop') AND maker <> ALL(SELECT maker FROM product WHERE type = 'Printer');
