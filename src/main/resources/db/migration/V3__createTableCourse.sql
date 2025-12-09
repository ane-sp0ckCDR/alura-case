CREATE TABLE Course (
    id        bigint(20)  NOT NULL AUTO_INCREMENT,
    name      varchar(50) NOT NULL,
    code      varchar(10) NOT NULL,
    instructor bigint(20) NOT NULL,
    description     varchar(50) NOT NULL,
    status      enum('ACTIVE', 'INACTIVE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'ACTIVE',
    inactDate datetime,
    PRIMARY KEY (id),
    CONSTRAINT fk_course_instructor FOREIGN KEY (instructor) REFERENCES User(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;
