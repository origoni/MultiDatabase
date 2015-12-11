# MultiDatabase
SpringBoot + Spring Data JPA + Multi DB Test

Very Simple Multiple DataBase

## Quick Start
- JDK 1.8 or later
- Maven 3.0+

```
git clone https://github.com/origoni/MultiDatabase.git
cd MultiDatabase/
mvn spring-boot:run
```

- visit [http://localhost:8080/](http://localhost:8080/)


## Test Data
- http://localhost:8080/addUser?name=origoni
- http://localhost:8080/listUser
- http://localhost:8080/addNote?note=SpringBoot_Multiple_DataBase_Test
- http://localhost:8080/listNote

## Check DB
- http://localhost:8080/h2-console
 - JDBC URL: jdbc:h2:mem:article
 - JDBC URL: jdbc:h2:mem:user
- Other option is the default.

