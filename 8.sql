SELECT distinct (SELECT COUNT(laptop.code) FROM laptop) as laptop, (SELECT COUNT(printer.code) FROM printer) as printer, (SELECT COUNT(pc.code) FROM pc) as pc
FROM product

