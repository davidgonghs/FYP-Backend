CREATE TABLE user
(
    user_id          BIGINT PRIMARY KEY,
    user_img         VARCHAR(255),
    nickname         VARCHAR(50),
    sign             VARCHAR(255),
    email            VARCHAR(50) UNIQUE NOT NULL,
    phone            VARCHAR(15),
    gender           ENUM('Male', 'Female', 'Other') DEFAULT 'Other',
    birthday         DATE,
    password         VARCHAR(255) NOT NULL,
    created_time     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by       BIGINT
);

CREATE TABLE user_settings
(
    settings_id                      BIGINT PRIMARY KEY,
    user_id                          BIGINT,
    calculation_mode                 VARCHAR(20),
    pomodoro_intervals               INT,
    pomodoro_rest_time               INT,
    voice_reminder_1       VARCHAR(255) comment 'url of the voice reminder where are the user',
    voice_reminder_2 VARCHAR(255) comment 'incorrect_posture',
    voice_reminder_3     VARCHAR(255) comment 'rest_time',
    daily_usage_reminder_time        TIME,
    created_time     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_time     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by                       BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE user_daily_statistics
(
    data_id          BIGINT PRIMARY KEY,
    user_id          BIGINT,
    total_usage_time INT,
    usage_time       DECIMAL(5, 2),
    sitting_accuracy DECIMAL(5, 2),
    created_time     TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE usage_history
(
    history_id       BIGINT PRIMARY KEY,
    user_id          BIGINT,
    usage_time       DECIMAL(5, 2),
    sitting_accuracy DECIMAL(5, 2),
    created_time     TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE role
(
    role_id   BIGINT PRIMARY KEY,
    role_name VARCHAR(20)
);

CREATE TABLE user_roles
(
    user_role_id BIGINT PRIMARY KEY,
    user_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);
