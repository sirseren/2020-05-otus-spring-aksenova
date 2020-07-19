create table AUTHOR
(
    ID BIGINT auto_increment,
    NAME VARCHAR(200) not null
);

create unique index AUTHOR_ID_UINDEX
    on AUTHOR (ID);

alter table AUTHOR
    add constraint AUTHOR_PK
        primary key (ID);

create table GENRE
(
    ID BIGINT auto_increment,
    NAME VARCHAR(100) not null
);

create unique index GENRE_ID_UINDEX
    on GENRE (ID);

create unique index GENRE_NAME_UINDEX
    on GENRE (NAME);

alter table GENRE
    add constraint GENRE_PK
        primary key (ID);

create table BOOK
(
    ID BIGINT auto_increment,
    GENRE_ID BIGINT not null,
    AUTHOR_ID BIGINT not null,
    NAME VARCHAR(200),
    ISBN VARCHAR(30),
    constraint BOOK_AUTHOR_ID_FK
        foreign key (AUTHOR_ID) references AUTHOR (ID),
    constraint BOOK_GENRE__FK
        foreign key (GENRE_ID) references GENRE (ID)
);

create unique index BOOK_ID_UINDEX
    on BOOK (ID);

alter table BOOK
    add constraint BOOK_PK
        primary key (ID);

