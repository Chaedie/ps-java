-- 코드를 입력하세요


#7월 총주문량
SELECT fh.FLAVOR
FROM (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_JULY
        FROM JULY
        GROUP BY FLAVOR) AS j
JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_FIRST_HALF
        FROM FIRST_HALF
        GROUP BY FLAVOR) AS fh
        ON j.FLAVOR = fh.FLAVOR
GROUP BY fh.FLAVOR
ORDER BY SUM(j.TOTAL_JULY + fh.TOTAL_FIRST_HALF) DESC
LIMIT 3;
