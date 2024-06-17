-- Create the table structure for the task table.
CREATE TABLE task
(
    id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(255) NOT NULL,
    priority varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);