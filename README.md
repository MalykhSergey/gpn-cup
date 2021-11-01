# Java-API. Rest->Soap
### To run the project, clone the repository and then use the command:  
mvnw spring-boot: run
### To complete the request, you must send your request one of the addresses:
* / add - add numbers
* / subtract - to subtract the second from the first
* / divided - to  divide the first by the second
* / multiply - to multiply numbers
### You should attach JSON-body like this to your request:
{  
    "intA":"A",  
    "intB":"A"  
}  
### where A is the first number, B is the second number. For example {"intA":"32","intB":"21"}.
### As a result, you will receive a number, which will be the answer.
### Example request:

POST /add HTTP/1.1  
Host: localhost:8080  
Content-Type: application/json  
Content-Length: 44  
  
{  
    "intA":"-2125",  
    "intB":"3215"  
}  
### Response:  
1090
