SELECT product.maker, min(price)
FROM product INNER JOIN printer ON product.model = printer.model
WHERE printer.color = 'n';
