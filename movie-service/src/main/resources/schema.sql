CREATE TABLE MOVIES (
                        ID VARCHAR2(36) PRIMARY KEY,
                        TITLE VARCHAR2(255) NOT NULL,
                        LANGUAGE VARCHAR2(100) NOT NULL,
                        GENRE VARCHAR2(100) NOT NULL,
                        CERTIFICATE VARCHAR2(50),
                        DURATION_MIN NUMBER(5),
                        RELEASE_DATE DATE,
                        DIRECTOR VARCHAR2(255),
                        CAST_NAMES CLOB,
                        SYNOPSIS CLOB,
                        CREATED_AT TIMESTAMP,
                        UPDATED_AT TIMESTAMP
);