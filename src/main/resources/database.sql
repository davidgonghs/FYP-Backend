CREATE TABLE users
(
    user_id          INT AUTO_INCREMENT,
    user_img         VARCHAR(255),
    nickname         VARCHAR(50),
    sign             VARCHAR(255),
    email            VARCHAR(50) UNIQUE NOT NULL,
    phone            VARCHAR(15),
    gender           VARCHAR(10),
    birthday         DATE,
    password         VARCHAR(255) NOT NULL, -- assuming hashed passwords
    created_time     DATETIME,
    updated_time      DATETIME,
    updated_by       INT,
    PRIMARY KEY (user_id)
);

CREATE TABLE user_settings
(
    user_id                          INT PRIMARY KEY,
    calculation_mode                 ENUM('CPU', 'GPU', 'NNAPI'),
    pomodoro_intervals               INT,
    pomodoro_rest_time               INT,
    voice_reminder_1       VARCHAR(255) comment 'url of the voice reminder where are the user',
    voice_reminder_2 VARCHAR(255) comment 'incorrect_posture',
    voice_reminder_3     VARCHAR(255) comment 'rest_time',
    daily_usage_reminder_time        TIME,
    created_time                     DATETIME,
    updated_time                      DATETIME,
    updated_by                       INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE user_daily_statistics
(
    data_id          INT AUTO_INCREMENT,
    user_id          INT,
    total_usage_time INT,
    usage_time       DECIMAL(5, 2),
    sitting_accuracy DECIMAL(5, 2),
    created_time      DATETIME,
    PRIMARY KEY (data_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE usage_history
(
    history_id       INT AUTO_INCREMENT,
    user_id          INT,
    usage_time       DECIMAL(5, 2),
    sitting_accuracy DECIMAL(5, 2),
    created_time      DATETIME,
    PRIMARY KEY (history_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE roles
(
    role_id   INT AUTO_INCREMENT,
    role_name VARCHAR(20),
    PRIMARY KEY (role_id)
);

CREATE TABLE user_roles
(
    user_id INT,
    role_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    PRIMARY KEY (user_id, role_id)
);