-- 코드를 입력하세요
SELECT USER_ID, 
       NICKNAME,
       CONCAT(user.CITY, " ",
              user.STREET_ADDRESS1, " ", 
              user.STREET_ADDRESS2) AS 전체주소,
       CONCAT(LEFT(TLNO, 3), "-", MID(TLNO, 4, 4),"-", RIGHT(TLNO, 4))  AS 전화번호
FROM USED_GOODS_USER AS user
JOIN USED_GOODS_BOARD AS board
    ON user.USER_ID = board.WRITER_ID
GROUP BY USER_ID
    HAVING Count(USER_ID) >= 3
ORDER BY USER_ID DESC;