CREATE TABLE users (
    id bigint auto_increment not null primary key,
    role varchar not null,
    email varchar not null unique,
    password varchar not null
);  

CREATE TABLE notes (
    id bigint auto_increment not null primary key,
    user_id bigint not null,
    status varchar not null,
    name varchar not null,
    description varchar,
    path_to_images varchar,
    foreign key(user_id) references users
);

CREATE TABLE messages (
    
);