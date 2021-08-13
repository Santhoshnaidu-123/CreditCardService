# CreditCardService

How to run the app locally?
pull image from docker using command = >docker run -p 8080:8080 arsaha28/pscreditcardapp
Then open URL in browser
http://localhost:8080/sapient/swagger-ui/index.html

Sample input for creating a new credit card
{
  "balance": 0,
  "cardLimit": 0,
  "cardNumber": "79927398713",
  "owner": "Arnab"
}
Samle URL for invoking get api
curl -X GET "http://localhost:8080/sapient/card/getall?page=0&size=10" -H "accept: application/json"
