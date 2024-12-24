SELECT EMP_NO,
       EMP_NAME,
       GRADE,
       CASE
           WHEN GRADE = 'S' THEN (SAL * 0.2)
           WHEN GRADE = 'A' THEN (SAL * 0.15)
           WHEN GRADE = 'B' THEN (SAL * 0.1)
           ELSE 0
       END AS BONUS
FROM (
    SELECT HE.EMP_NO,
           HE.EMP_NAME,
           HE.SAL,
           CASE
               WHEN AVG(HG.SCORE) >= 96 THEN 'S'
               WHEN AVG(HG.SCORE) >= 90 THEN 'A'
               WHEN AVG(HG.SCORE) >= 80 THEN 'B'
               ELSE 'C'
           END AS GRADE
    FROM HR_EMPLOYEES AS HE
    INNER JOIN HR_GRADE AS HG ON HE.EMP_NO = HG.EMP_NO
    GROUP BY HE.EMP_NO
) AS A
ORDER BY EMP_NO