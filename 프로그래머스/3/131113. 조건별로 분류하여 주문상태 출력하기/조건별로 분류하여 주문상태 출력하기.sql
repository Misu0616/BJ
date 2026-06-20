SELECT ORDER_ID, PRODUCT_ID, 
    case when OUT_DATE is null then ''
    else  to_char(OUT_DATE, 'yyyy-mm-dd') 
    end as OUT_DATE, 
    case when OUT_DATE <= to_Date('2022-05-01', 'yyyy-mm-dd') then '출고완료'
         when OUT_DATE > to_Date('2022-05-01', 'yyyy-mm-dd') then '출고대기'
    else '출고미정'
    end as 출고여부
from FOOD_ORDER
order by ORDER_ID;
