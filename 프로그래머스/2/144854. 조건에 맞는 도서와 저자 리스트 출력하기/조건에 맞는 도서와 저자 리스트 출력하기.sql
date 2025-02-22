SELECT BK.BOOK_ID,
       AT.AUTHOR_NAME,
       DATE_FORMAT(BK.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK AS BK
INNER JOIN AUTHOR as AT ON BK.AUTHOR_ID = AT.AUTHOR_ID
WHERE BK.category = '경제'
ORDER BY 3 ASC