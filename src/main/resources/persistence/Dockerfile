FROM postgres:16

COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_DB deck
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD password