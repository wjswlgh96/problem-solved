-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요. 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.
SELECT YEAR(SALES_DATE) AS YEAR,
       MONTH(SALES_DATE) AS MONTH,
       UI.GENDER,
       COUNT(DISTINCT UI.USER_ID) AS USERS
FROM USER_INFO AS UI
INNER JOIN ONLINE_SALE AS OS ON UI.USER_ID = OS.USER_ID
WHERE UI.GENDER IS NOT NULL
GROUP BY 1, 2, 3
ORDER BY 1, 2, 3
