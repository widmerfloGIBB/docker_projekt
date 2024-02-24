# Spring Boot + PostgreSQL Dockerized

### Creating a docker network
``` bash
docker network create my_network
``` 
### Postgresql docker setup
``` bash
#Move to the position of the Dockerfile
cd .\src\main\resources\persistence\

#Build PostfresSQL image (From the position of the Dockerfile)
docker build . -t postgres_db

#Run Postgres container from image
docker run --name my_database --network my_network postgres_db
```

### Spring Boot docker setup
``` bash
#Go back to the Spring Boot Dockerfile
cd ../../../../

#Build Spring boot image (From the position of the Dockerfile)
docker build . -t spring_boot_service

#Run backend service and hos tit on localhost port 8080
docker run -d -p 8080:8080 --name backend --network my_network spring_boot_service

```