# CreditCardService
CreditCardService has 3 main components.
 * A rest controller with getall and add endpoint 
 * A validation layer to apply multiple validation before creating a new card 
 * A Process layer to orchestrate various steps of creating a card

##How to run the app locally?
Useful docker command to build and deploy images 
Image has already been uploaded in docker as public image.
<code>
 * docker build -t pscreditcardapp .
 * docker tag pscreditcardapp arsaha28/pscreditcardapp
 * docker push arsaha28/pscreditcardapp
 * docker rmi -f arsaha28/pscreditcardapp
 * docker run -p 8080:8080 arsaha28/pscreditcardapp
</code>
   
Then open URL in browser
http://localhost:8080/sapient/swagger-ui/index.html

##Sample input for creating a new credit card
**Input**
<code>
{
  "balance": 0,
  "cardLimit": 0,
  "cardNumber": "79927398713",
  "owner": "Arnab"
}
</code>
<br></br>
**output with HTTP status 200**
<code>
{
  "owner": "Arnab",
  "balance": 0,
  "cardNumber": "79927398713",
  "cardLimit": 0
}
</code>

##Sample input to attempt to create a new credit card which has invalid card number
**Input**
<code>
{
  "balance": 0,
  "cardLimit": 0,
  "cardNumber": "79927398712",
  "owner": "Arnab"
}
</code>
<br></br>
**Output with HTTP status 400**
<code>
{
"status": "BAD_REQUEST",
"message": "Input validation failed [ Validation failed : class com.publicis.sapient.validator.CreditCardNumberValidator]"
}
</code>
##Sample input to attempt to create a new credit card which has invalid card number and balance
**Input**
<code>
{
  "balance": 100,
  "cardLimit": 0,
  "cardNumber": "79927398712",
  "owner": "Arnab"
}
</code>
<br></br>
**Output with HTTP status 400**
<code>
{
  "status": "BAD_REQUEST",
  "message": "Input validation failed [ Validation failed : class com.publicis.sapient.validator.CreditCardNumberValidator Validation failed : class com.publicis.sapient.validator.BalanceValidator]"
}
</code>

##URL for invoking get api
curl -X GET "http://localhost:8080/sapient/card/getall?page=0&size=10" -H "accept: application/json"
