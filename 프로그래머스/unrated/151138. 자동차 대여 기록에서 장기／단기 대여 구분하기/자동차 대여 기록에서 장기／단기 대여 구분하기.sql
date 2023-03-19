-- 코드를 입력하세요
SELECT history_id,
       car_id,
       Date_format(start_date, "%Y-%m-%d") AS START_DATE,
       Date_format(end_date, "%Y-%m-%d")   AS END_DATE,
       ( CASE
           WHEN Datediff(end_date, start_date) >= 29 THEN "장기 대여"
           ELSE "단기 대여"
         END )                             AS RENT_TYPE
FROM   car_rental_company_rental_history
WHERE  Year(start_date) = 2022
       AND Month(start_date) = 9
ORDER  BY HISTORY_ID DESC; 