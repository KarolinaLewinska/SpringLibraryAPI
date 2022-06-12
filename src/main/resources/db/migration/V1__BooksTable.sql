CREATE TABLE Books (
    id UUID NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    yearOfRelease DATE NOT NULL,
    isAvailable VARCHAR(10) NOT NULL
);