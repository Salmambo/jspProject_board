create database simpleBoard default character set utf8;

use simpleBoard;

create table member (
    id varchar(50) primary key,
    password varchar(10) not null,
    nickname varchar(50) not null
);

select * from member;

create table article (
    number int auto_increment primary key,
    title varchar(255) not null,
    id varchar(50) not null,
    nickname varchar(50) not null,
    regdate datetime not null,
    content text
);

select * from article;

create table comment (
    number int auto_increment primary key,
    article int not null,
    id varchar(50) not null,
    nickname varchar(50) not null,
    regdate datetime not null,
    content varchar(255)
);

select * from comment;