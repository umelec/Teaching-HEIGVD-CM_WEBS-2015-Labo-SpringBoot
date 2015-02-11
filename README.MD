# Smart City - Citizen Engagement - Spring Boot Skeleton

## Introduction

The implementation is done with:

- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Spring Data MongoDB](http://projects.spring.io/spring-data-mongodb/)
- [MongoDB](http://www.mongodb.org/)
- [Jersey](https://jersey.java.net/)

## Requirements

- Java 1.6+
- Maven 3.0.5+
- Mongo 2.6+

## Implementation

Base your implementation on the info from [iFlux blog's post](http://www.iflux.io/use-case/2015/02/03/citizen-engagement.html).

## Configure

First, rename the root package to a name of your choice.

Then, change the database name in the class `MongoConfiguration`.

## Install / Deploy / Run

Just run the following command (or use the proper Run goal in Custom in NetBeans). Be sure MongoDB is running before running the command.

```bash
$> mvn clean package spring-boot:run
```

## Test

The appliation is runing on `http://localhost:8080`. You should be able to access the following:

### Data population

- POST /api/data/populate

### User resource

- GET /api/users
- POST /api/users
- GET /api/users/{id}
- PUT /api/users/{id}
- DELETE /api/users/{id}
