# java-security-jwt

Steps to run the application

1. After having checked out the code, execute mvn spring-boot:run
2. Open postman on Chrome browser and using POST method against the url http://localhost:8080/token pass the below user credentials in the body.

   {
	  "username" : "admin",
	  "password" : "123"
   }
   
   Click on Send. Itwill create the JWT token that could further be used to other resources that need authorization.
 
3. Once the JWT is availed, authorized resource could be retrieved by passing the JWT token by providing the header as given below.

  URL : http://localhost:8080/app
  Headers:
          Key: Authorization, Value: Token eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInBhc3N3b3JkIjoiMTIzIn0.QR142xUNAxciN4KcKWlaXj-FJdgDLKWrLNNWWibQ63U
          
   And finally it will display the result that needs authentication and authorization.       
