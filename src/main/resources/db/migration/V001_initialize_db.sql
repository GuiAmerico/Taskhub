DROP TABLE IF EXISTS `_board`;
CREATE TABLE `board`
    (
        id BINARY(16) PRIMARY KEY NOT NULL,
        name VARCHAR(255) NOT NULL,
        description VARCHAR(255),
        created DATETIME NOT NULL,
        responsible_name VARCHAR(255) NOT NULL,

    );
DROP TABLE IF EXISTS `_column`;
CREATE TABLE `_column`
    (
        id BINARY(16) PRIMARY KEY NOT NULL,
        name VARCHAR(255) NOT NULL,
        wip INT,
        created DATETIME NOT NULL,
        board_id BINARY(16) NOT NULL,

        FOREIGN KEY (board_id) REFERENCES `_board`(id)
    );
DROP TABLE IF EXISTS `_task`;
CREATE TABLE `_task`
    (
        id BINARY(16) PRIMARY KEY NOT NULL,
        priority VARCHAR(255),
        title VARCHAR(255) NOT NULL,
        state VARCHAR(255) NOT NULL,
        responsible_name VARCHAR(255) NOT NULL,
        tag VARCHAR(255),
        description TEXT,
        column_id BINARY(16),
        FOREIGN KEY (column_id) REFERENCES `_column`(id)

    );