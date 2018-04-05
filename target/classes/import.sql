-- MYSQL
INSERT INTO user (ID, USERNAME, PASSWORD, NAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE, PICTURE, ISACTIVE, ROLE, DESCRIPTION ) VALUES (1, 'admin@gmail.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'admin', 'admin', 1, STR_TO_DATE('01-01-2016', '%d-%m-%Y'), 'https://i0.wp.com/www.sopitas.com/wp-content/uploads/2016/07/michael-jackson-sonrisa.jpg?fit=650%2C366', '1', '2', 'Hi friends');
INSERT INTO user (ID, USERNAME, PASSWORD, NAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE, PICTURE, ISACTIVE, ROLE, DESCRIPTION ) VALUES (2, 'user@gmail.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user',  1, STR_TO_DATE('01-01-2016','%d-%m-%Y'), 'https://i0.wp.com/www.sopitas.com/wp-content/uploads/2016/07/michael-jackson-sonrisa.jpg?fit=650%2C366', '1', '1', 'Hi friends' );
INSERT INTO user (ID, USERNAME, PASSWORD, NAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE, PICTURE, ISACTIVE, ROLE, DESCRIPTION ) VALUES (3, 'mentor@gmail.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'mentor', 'mentor',  1, STR_TO_DATE('01-01-2016','%d-%m-%Y'), 'https://i0.wp.com/www.sopitas.com/wp-content/uploads/2016/07/michael-jackson-sonrisa.jpg?fit=650%2C366', '1', '4', 'Hi friends' );
INSERT INTO user (ID, USERNAME, PASSWORD, NAME, LASTNAME, ENABLED, LASTPASSWORDRESETDATE, PICTURE, ISACTIVE, ROLE, DESCRIPTION ) VALUES (4, 'enterprise@gmail.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'enterprise', 'enterprise',  1, STR_TO_DATE('01-01-2016','%d-%m-%Y'), 'https://i0.wp.com/www.sopitas.com/wp-content/uploads/2016/07/michael-jackson-sonrisa.jpg?fit=650%2C366', '1', '3', 'Hi friends' );


INSERT INTO notificationtype (ID, REDIRECT, NAME) VALUES (1, '/meetings', 'newMeeting');
INSERT INTO notificationtype (ID, REDIRECT, NAME) VALUES (2, '/pupils', 'newPupil');
INSERT INTO notificationtype (ID, REDIRECT, NAME) VALUES (3, '/mentors', 'newMentor');


INSERT INTO authority (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO authority (ID, NAME) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authority (ID, NAME) VALUES (3, 'ROLE_ENTERPRISE');
INSERT INTO authority (ID, NAME) VALUES (4, 'ROLE_MENTOR');


INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (3, 4);
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (4, 3);


INSERT INTO project (ID, DESCRIPTION, NAME, PICTURE, USER_ID) VALUES (1, 'Default project', 'Default project', 'https://cdn.lynda.com/course/506926/506926-636238695730179167-16x9.jpg', '2' );
INSERT INTO project (ID, DESCRIPTION, NAME, PICTURE, USER_ID) VALUES (2, 'Default project 2', 'Default project 2', 'https://cdn.lynda.com/course/506926/506926-636238695730179167-16x9.jpg', '2' );
