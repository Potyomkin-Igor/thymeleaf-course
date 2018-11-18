INSERT INTO companies(id, name) VALUES (1, 'EPUM'),(2, 'LuxSoft'),(3, 'SoftServe'),(4, 'Ardas'),(5, 'Smeler'),(6, 'InventorSoft');

INSERT INTO skills(id, name) VALUES (1, 'JAVA'), (2, 'PHP'), (3, 'PYTHON'), (4, 'RUBY'), (5, 'MYSQL'), (6, 'POSTGRES'), (7, 'HIBERNATE'), (8, 'SPRING'), (9, 'THYMELEAF'), (10, 'JDBC'), (11, 'JUNIT');

INSERT INTO employees(id, first_name, last_name, email, gender, company_id) VALUES (1, 'Alex', 'Frolov', 'alexFrolov@mail.com', 'MALE', 1), (2, 'Anton', 'Velov', 'antonVelov@mail.com', 'MALE', 1), (3, 'Anna', 'Menkova', 'annaMenkova@mail.com', 'FEMALE', 1), (4, 'Jon', 'Smith', 'jonSmith@mail.com', 'MALE', 2), (5, 'Mikel', 'Letto', 'mikelLetto@mail.com', 'MALE', 2), (6, 'Markus', 'Morison', 'markusMorison@mail.com', 'MALE', 2), (7, 'Julia', 'Sun', 'juliaSun@mail.com', 'FEMALE', 3), (8, 'Artem', 'Filatov', 'artemFilatov@mail.com', 'MALE', 3), (9, 'Nasty', 'Pimkin', 'nastyPimkin@mail.com', 'FEMALE', 4), (10, 'Oleg', 'Fidos', 'olegFidos@mail.com', 'MALE', 4), (11, 'Rostislav', 'Semenov', 'rostislavSemenov@mail.com', 'MALE', 5), (12, 'Roman', 'Hlib', 'romanHlib@mail.com', 'MALE', 5), (13, 'George', 'Simov', 'georgeSimov@mail.com', 'MALE', 6), (14, 'Illiy', 'Marchel', 'IlliyMarchel@mail.com', 'MALE', 6);

INSERT INTO employees_skills(employee_id, skill_id) VALUES (1, 1), (1, 6), (1, 7), (2, 2), (2, 5), (3, 11), (3, 10), (4, 1), (4, 9), (5, 1), (5, 8), (6, 6), (6, 5), (7, 2), (7, 8), (8, 3), (8, 10), (9, 3), (9, 5), (10, 2), (10, 11), (11, 1), (11, 7), (12, 11), (12, 9), (13, 3), (13, 10), (14, 1), (14, 8);

INSERT INTO users(id, first_name, last_name, email, password, role) VALUES (1, 'Martin', 'Fowler', 'thymeleaf@test.com', 'thymeleaf', 'ROLE_USER');