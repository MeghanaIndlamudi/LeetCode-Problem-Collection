/* Write your PL/SQL query statement below */
-- with first_login as (
-- select player_id,min(event_date) as first,event_date from Activity group by player_id,event_date
-- )
-- select round(count(case when first=DATE_SUB(event_date, INTERVAL 1 DAY) then 1 else 0 )/count(player_id),2) as fraction from first_login ;

WITH first_login AS (
    SELECT 
        player_id,
        MIN(event_date) AS first_event_date
    FROM Activity
    GROUP BY player_id
)
SELECT 
    ROUND(
        COUNT(DISTINCT CASE WHEN A.event_date = F.first_event_date + 1 THEN A.player_id END) 
        / COUNT(DISTINCT A.player_id), 
        2
    ) AS fraction
FROM Activity A
JOIN first_login F
ON A.player_id = F.player_id;


