/* Write your PL/SQL query statement below */
with ste as (
select class,count(student) as st from Courses group by class
)
select class from ste where st>4; 