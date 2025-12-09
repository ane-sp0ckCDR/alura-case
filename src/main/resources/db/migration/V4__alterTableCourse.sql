ALTER TABLE Course
ADD COLUMN category BIGINT(20) NOT NULL,
ADD CONSTRAINT fk_course_category
    FOREIGN KEY (category) REFERENCES Category(id);
