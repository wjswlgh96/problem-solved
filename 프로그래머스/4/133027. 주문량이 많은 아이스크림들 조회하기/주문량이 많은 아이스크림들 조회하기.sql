SELECT FLAVOR
FROM
(
SELECT FH.FLAVOR,
       SUM(FH.TOTAL_ORDER + J.TOTAL_ORDER) AS TOTAL_SUM
FROM FIRST_HALF AS FH
INNER JOIN JULY AS J ON FH.FLAVOR = J.FLAVOR
GROUP BY 1
ORDER BY 2 DESC
LIMIT 3
) AS A