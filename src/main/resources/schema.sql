DROP TABLE IF EXISTS poll;
DROP TABLE IF EXISTS userAnswer;

CREATE TABLE poll (
 poll_id INT PRIMARY KEY AUTO_INCREMENT,
 question_title VARCHAR(100) NOT NULL DEFAULT ' ',
 first_answer VARCHAR(100) NOT NULL DEFAULT ' ',
 second_answer VARCHAR(100) NOT NULL DEFAULT ' ',
 third_answer VARCHAR(100) NOT NULL DEFAULT ' ',
 fourth_answer VARCHAR(100) NOT NULL DEFAULT ' '
);

CREATE TABLE userAnswer (
user_id INT ,
poll_id INT,
poll_answer VARCHAR(100) NOT NULL DEFAULT ' ',
PRIMARY KEY (user_id,poll_id),
FOREIGN KEY (poll_id) REFERENCES poll(poll_id)
)