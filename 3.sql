SELECT pc.model, product.maker
FROM product INNER JOIN pc ON product.model=pc.model AND price < 600