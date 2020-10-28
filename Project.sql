CREATE TABLE project (
    id NUMBER(8,0) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    date_created DATE NOT NULL,
    internal_id VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_ID PRIMARY KEY (id)
);

INSERT INTO project(id, name, date_created, internal_id)
VALUES (2,'Spring Project 2', '07-JUN-02', 'internalId2');