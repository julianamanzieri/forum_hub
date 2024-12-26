create table topics(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(5000) not null,
    creation_date timestamp not null,,
    status tinyint varchar(100) not null,
    author bigint not null,
    course_id bigint not null,

    primary key(id),
);
