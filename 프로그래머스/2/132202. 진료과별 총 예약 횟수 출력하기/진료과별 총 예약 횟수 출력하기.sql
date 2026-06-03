SELECT MCDP_CD as "진료과코드", count(*) as "5월예약건수"
from APPOINTMENT
where To_char(APNT_YMD, 'YYYYMM') = '202205'    
group by MCDP_CD
order by "5월예약건수", MCDP_CD;