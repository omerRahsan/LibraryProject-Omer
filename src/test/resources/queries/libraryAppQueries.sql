SELECT full_name,count(user_id)
from users
inner join book_borrow on users.id = book_borrow.user_id
group by full_name;


select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id
group by full_name
order by 2 desc ;


SELECT name
from book_categories;