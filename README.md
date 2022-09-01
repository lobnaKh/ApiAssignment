# Api Assignemnt

It consists of an API to be used for opening a new “current account” of already existing customers.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

* [JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): Java SE Development Kit 8
* [H2 In memory database]: database
* [Apache Maven 3.6.0](https://maven.apache.org/download.cgi): Dependency Management

### Installing

A step by step series of examples that tell you how to get a development env running

1- Download source code :

https://github.com/lobnaKh/ApiAssignment.git
```
2- Download the project dependencies:
```sh
mvn clean install
```
3- Launch the application from the IDE :
```sh
* mvn spring-boot:run 
OR 
* run main ApiApplication
```
4- View Swagger documentation of APIs :

http://localhost:8080/swagger-ui.html

5 - TEST ENDPOINT OF CREATING NEW ACCOUNT : 

 POST http://localhost:8080/accounts
 
 REQUEST BODY (JSON FORMAT) : customerId (Type int), initialCredit (Type double)
 
 6 - TEST ENDPOINT OF GETTING USER INFORMATION :
  
 GET http://localhost:8080/customers/{id}
 
 PATH VARIABLE : id (Type int)

## Acknowledgments

* Java 8 - [What's New in JDK 8](https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)
* [Spring Boot 2.7.3](https://spring.io/) - Spring Framework 4.3.23
* [Maven](https://maven.apache.org/) - Dependency Management
* [Apache Tomcat 7 OR 8](https://tomcat.apache.org/download-70.cgi) - Web server

## Authors
* **Lobna KHALSI**