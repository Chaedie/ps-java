-- 코드를 입력하세요
SELECT BOARD_ID,
        WRITER_ID, 
        TITLE, 
        PRICE, 
        (CASE 
            WHEN STATUS = "SALE" THEN "판매중"
            WHEN STATUS = "RESERVED" THEN "예약중"
            ELSE  "거래완료"
        END) AS STATUS
FROM used_goods_board
WHERE CREATED_DATE = "2022-10-5"
ORDER BY BOARD_ID DESC;