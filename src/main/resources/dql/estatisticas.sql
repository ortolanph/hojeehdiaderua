select distinct loda_dia, count(loda_dia)
  from diaderua.logradourodata
 where loda_mes = 7
 group by loda_dia
 order by loda_dia;

select distinct loda_uf, count(loda_uf)
  from diaderua.logradourodata
 where loda_mes = 7
 group by loda_uf
 order by 2 desc;

select distinct loda_cidade, count(loda_cidade)
  from diaderua.logradourodata
 where loda_mes = 7
 group by loda_cidade
 order by 2 desc
 limit 10;