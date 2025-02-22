SELECT b.AUTHOR_ID,
       a.AUTHOR_NAME,
       b.CATEGORY,
       SUM(b.PRICE * bs.SALES) as TOTAL_SALES
FROM BOOK AS b 
JOIN AUTHOR AS a ON b.AUTHOR_ID = a.AUTHOR_ID
JOIN BOOK_SALES AS bs ON b.BOOK_ID = bs.BOOK_ID
WHERE bs.SALES_DATE LIKE '2022-01%'
GROUP BY 1, 2, 3
ORDER BY 1 ASC, 3 DESC