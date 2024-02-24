create sequence card_id_sequence start with 1 increment by 1;

create table card (
                      id integer not null,
                      definition varchar(255),
                      term varchar(255),
                      primary key (id)
);

insert into card(id, definition, term) values (nextval('card_id_sequence'), 'hello', 'hallo');
insert into card(id, definition, term) values (nextval('card_id_sequence'), 'bye', 'tschüss');