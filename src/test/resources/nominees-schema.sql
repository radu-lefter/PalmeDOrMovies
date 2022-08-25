DROP TABLE nominees;
CREATE TABLE IF NOT EXISTS nominees (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(65) NOT NULL,
    originalTitle varchar(65),
    year int NOT NULL,
    director varchar(55) NOT NULL, 
    country varchar(35) NOT NULL, 
    language varchar(35), 
    plot text, 
    wiki varchar(95), 
    runTimeMin int,
    genre varchar(55),
    winner bool,
    PRIMARY KEY (id)
);