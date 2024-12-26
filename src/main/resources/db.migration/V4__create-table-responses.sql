create table responses(
    id bigint not null auto_increment,
    message varchar(250) not null,
    topic_id bigint not null,
    creation_date timestamp not null,
    author_id bigint not null,
    solution boolean default false,

    primary key(id)
);