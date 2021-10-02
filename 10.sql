SELECT product.maker, pc.model, product.type, pc.price
FROM product JOIN pc ON product.model = pc.model
WHERE product.maker = 'B'
UNION ALL
SELECT product.maker, laptop.model, product.type, laptop.price
FROM product JOIN laptop ON product.model = laptop.model
WHERE product.maker = 'B'
UNION ALL
SELECT product.maker, printer.model, product.type, printer.price
FROM product JOIN printer ON product.model = printer.model
WHERE product.maker = 'B'