CREATE TABLE users(
    id BIGINT NOT NULL auto_increment,
    username VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(40) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE posts(
    id BIGINT NOT NULL auto_increment,
    user_id BIGINT NOT NULL UNIQUE,
    content VARCHAR(140) NOT NULL,
    reactions INT,
    comments INT,
    posted_date_time DATETIME NOT NULL,
    visible BOOLEAN NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_posts_users_id FOREIGN KEY(user_id) REFERENCES users(id)
);