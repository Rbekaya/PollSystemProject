INSERT INTO poll (question_title, first_answer, second_answer, third_answer, fourth_answer)
VALUES('Where is your preferred place to travel?','USA','France','South America', 'Thailand'),
      ('Between the following, what do you most love to do?',
            'Watch TV',
            'Play the computer',
            'Hanging out with friends',
            'Travel the world');


INSERT INTO userAnswer (user_id,poll_id,poll_answer)
VALUES (1,1,'USA'),
        (1,2, 'Watch TV'),
        (2,2, 'Travel the world'),
        (3,1, ' '),
        (4,1,'South America');