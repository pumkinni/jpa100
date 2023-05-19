DROP TABLE IF EXISTS NOTICE;
DROP TABLE IF EXISTS USER_ENTITY;




create table USER_ENTITY
(
    ID           BIGINT auto_increment primary key,
    EMAIL        VARCHAR(255),
    USER_NAME     VARCHAR(255),
    PASSWORD     VARCHAR(255),
    PHONE     VARCHAR(255),
    REG_DATE     VARCHAR(255),
    UPDATE_DATE     VARCHAR(255)
);

create table NOTICE
(
    ID           BIGINT auto_increment primary key,
    TITLE        VARCHAR(255),
    CONTENTS     VARCHAR(255),

    HITS         INTEGER,
    LIKES        INTEGER,

    REG_DATE     TIMESTAMP,
    UPDATE_DATE  TIMESTAMP,
    DELETED_DATE TIMESTAMP,
    DELETED      BOOLEAN,

    USER_ID BIGINT,
    constraint FK_NOTICE_USER_ID foreign key(USER_ID) references USER_ENTITY(ID)
);