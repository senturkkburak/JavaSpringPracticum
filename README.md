Example Date Format For Requests:  2022-09-09T00:00:00

Example User Creation Request: Post request to - localhost:8080/users

{"id":1,"name":"burak","surname":"senturk","email":"burak.senturk@isik.edu.tr",
"phone":"05005005050"}

Example Product Creation Request: Post request to - localhost:8080/products

{
"id": 1,
"name": "yeniurun",
"price": "15",
"expireDate": "2022-06-06"
}

Example Comment Creation Request: Post request to - localhost:8080/comments
{
"id": 1,
"commentDate": "2022-06-06",
"commentText": "deneme",
"userId":1,
"productId":1 }

Get Requests 
-Bir ürüne ait yorumları listeleyen bir metot yazınız.
1)localhost:8080/comments?productId=1 (1=product id)

-Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
2)localhost:8080/comments?productId=1&minDate=2021-09-09T00:00:00&maxDate=2023-09-09T00:00:00

-Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
3)localhost:8080/comments?userId=1

-Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
4)localhost:8080/comments/1/2021-09-09T00:00:00/2023-09-09T00:00:00

Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
5)localhost:8080/products/expired

Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
6)localhost:8080/products/notexpired
