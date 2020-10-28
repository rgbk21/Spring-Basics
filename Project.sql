CREATE TABLE project (
    id NUMBER(8,0) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    date_created DATE NOT NULL,
    internal_id VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_ID PRIMARY KEY (id)
);

INSERT INTO project(id, name, date_created, internal_id)
VALUES (3,'Spring Project 3', '07-JUN-02', 'internalId3');

SELECT * FROM project;

ALTER TABLE project 
MODIFY id NUMBER(32,0);

ALTER TABLE project
MODIFY name VARCHAR2(255);

DESC project;

DELETE FROM project 
WHERE date_created > '07-JUN-02';






