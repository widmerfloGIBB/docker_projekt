# Spring Boot + PostgreSQL Dockerized

### Postgresql docker setup
``` bash
#Docker-Compose
docker-compose -f docker-compose.yml up -d

#Execute the Bash
docker exec -it postgres bash 

#Select the admin user
psql -U admin

#Create the deck database
CREATE DATABASE deck;

#Connect yourself with the Database
\c deck
```

### Spring Boot docker setup
``` bash
#Open a new Terminal

#Build Spring boot image (From the position of the Dockerfile)
docker build . -t spring_boot_service

#Create a docker network
docker network create my_network

#Run backend service and hos tit on localhost port 8080
docker run -d -p 8080:8080 --name backend --network my_network spring_boot_service
```

### Test Daten einfügen
``` bash
#Run these Commands in the Terminal from 'Postgres docker Setup
insert into card(id, definition, term) values (nextval('card_id_sequence'), 'hello', 'hallo');
insert into card(id, definition, term) values (nextval('card_id_sequence'), 'bye', 'tschüss');
```