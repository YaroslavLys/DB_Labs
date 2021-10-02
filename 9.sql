SELECT income.point, income.date, max(income.inc), max(outcome.out)
FROM income
JOIN outcome ON income.point = outcome.point
GROUP BY point, date;