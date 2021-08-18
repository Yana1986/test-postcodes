Use browser or this request to log in and get JSESSIONID

curl -c - 'http://localhost:8080/api/v1/auth/login' -F 'username=user' -F 'password=his1LeNR*p'

-----------------------

Use this request to pass in parameters the postcode range and get in the response body the list of names 
belonging to that postcode range, sorted alphabetically as well as the total number of characters of all names combined.

> curl -X GET 'http://localhost:8080/api/v1/areas/findSortedNamesWithNumberOfCharactersByPostcodes?postcodeFrom=postcodeFrom&postcodeTo=postcodeTo' \
--header 'Cookie: JSESSIONID=**JSESSIONID**'

For example:

> curl -X GET 'http://localhost:8080/api/v1/areas/findSortedNamesWithNumberOfCharactersByPostcodes?postcodeFrom=6000&postcodeTo=6430' \
--header 'Cookie: JSESSIONID=0A48315EB35D10DF27F18F2A9002CA20'

-----------------------

Use this request to pass a list of Names and Postcodes in the HTTP request body, and persist the data in a database.

> curl -X POST 'http://localhost:8080/api/v1/areas/createWithList' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=**JSESSIONID**' \
--data-raw **json**

For example:
curl -X POST 'http://localhost:8080/api/v1/areas/createWithList' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=0A48315EB35D10DF27F18F2A9002CA20' \
--data-raw '[
{
"postcode": "6430",
"name": "Kalgoorlie"
},
{
"postcode": "6430",
"name": "Piccadilly"
},
{
"postcode": "6000",
"name": "Perth"
},
{
"postcode": "6000",
"name": "Perth GPO"
},
{
"postcode": "6000",
"name": "CITY DELIVERY CENTRE"
}
]'