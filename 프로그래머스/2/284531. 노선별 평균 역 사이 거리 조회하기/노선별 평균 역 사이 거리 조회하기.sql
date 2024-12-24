SELECT ROUTE,
       CONCAT(CAST(ROUND(SUM(D_BETWEEN_DIST), 1) as CHAR), "km") as TOTAL_DISTANCE,
       CONCAT(CAST(ROUND(AVG(D_BETWEEN_DIST), 2) as CHAR), "km") as AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY 1
ORDER BY SUM(D_BETWEEN_DIST) DESC