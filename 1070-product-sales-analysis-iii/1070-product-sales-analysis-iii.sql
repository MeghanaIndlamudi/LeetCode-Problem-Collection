/* Write your PL/SQL query statement below */
with ste as (select min(year)as first_year,product_id from Sales group by product_id)
select s.product_id,s.first_year as first_year,s1.quantity,s1.price from ste s join Sales s1 on s.first_year=s1.year and s.product_id=s1.product_id;
