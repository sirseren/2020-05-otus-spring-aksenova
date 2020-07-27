create table PUBLIC.AUTHOR
(
    ID BIGINT auto_increment,
    NAME VARCHAR(200) not null
);

create unique index PUBLIC.AUTHOR_ID_UINDEX
    on PUBLIC.AUTHOR (ID);

alter table PUBLIC.AUTHOR
    add constraint AUTHOR_PK
        primary key (ID);

create table PUBLIC.GENRE
(
    ID BIGINT auto_increment,
    NAME VARCHAR(100) not null
);

create unique index PUBLIC.GENRE_ID_UINDEX
    on PUBLIC.GENRE (ID);

create unique index PUBLIC.GENRE_NAME_UINDEX
    on PUBLIC.GENRE (NAME);

alter table PUBLIC.GENRE
    add constraint GENRE_PK
        primary key (ID);

create table PUBLIC.BOOK
(
    ID BIGINT auto_increment,
    GENRE_ID BIGINT not null,
    AUTHOR_ID BIGINT not null,
    NAME VARCHAR(200),
    ISBN VARCHAR(30),
    constraint BOOK_AUTHOR_ID_FK
        foreign key (AUTHOR_ID) references PUBLIC.AUTHOR (ID),
    constraint BOOK_GENRE__FK
        foreign key (GENRE_ID) references PUBLIC.GENRE (ID)
);

create unique index PUBLIC.BOOK_ID_UINDEX
    on PUBLIC.BOOK (ID);

alter table PUBLIC.BOOK
    add constraint BOOK_PK
        primary key (ID);

