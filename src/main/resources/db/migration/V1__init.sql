
CREATE TABLE IF NOT EXISTS students (
    id SERIAL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    age INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS teachers (
     id SERIAL,
     firstname VARCHAR(50),
    lastname VARCHAR(50),
    subject VARCHAR(50),
    students_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (students_id) REFERENCES students(id)
    );



