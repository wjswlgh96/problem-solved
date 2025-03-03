SELECT YEAR(OS.SALES_DATE) AS YEAR,
       MONTH(OS.SALES_DATE) AS MONTH,
       GENDER,
       COUNT(DISTINCT UI.USER_ID) AS USERS
FROM USER_INFO AS UI
INNER JOIN ONLINE_SALE AS OS ON UI.USER_ID = OS.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY 1, 2, 3
ORDER BY 1, 2, 3