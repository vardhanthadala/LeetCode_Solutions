# Write your MySQL query statement below
SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans -- count how many times visited
FROM Visits v LEFT JOIN Transactions t 
ON v.visit_id = t.visit_id
WHERE  t.transaction_id IS NULL -- keeps only no transaction customer id's
GROUP BY  v.customer_id -- No.of times no transactions happens 