SELECT distinct maker
FROM product
WHERE type = 'PC' AND NOT maker <> ALL(SELECT maker FROM product WHERE type = 'Laptop');
