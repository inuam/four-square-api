# Description
Base Spring Boot application to demonstrate the use of Foursquare places API. Given a place name it'll return
a collection of places near by or and empty if nothing is found.


## Run tests
```
mvn clean test
```

## Start server

```
mvn spring-boot:run
```

Starts the server on port 8080; browse to http://localhost:8080/actuator/status for application status

## Swagger Docs
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html

## Outstanding
Writing integration test that at least starts the server and call an endpoint.