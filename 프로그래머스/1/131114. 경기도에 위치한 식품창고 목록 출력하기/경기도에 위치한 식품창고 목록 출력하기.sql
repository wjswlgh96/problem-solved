SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       COALESCE(FREEZER_YN, 'N') as FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE WAREHOUSE_NAME LIKE '%경기%'