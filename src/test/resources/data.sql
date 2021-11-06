insert into exams(name, starting_time, duration, bibliography, are_teams_allowed, exam_type)
values ('Software Engineering', '2021-11-20 12:00', 1.5, null, true, 'project presentation');
insert into exams(name, starting_time, duration, bibliography, are_teams_allowed, exam_type)
values ('Java', '2021-11-16 11:00', 2, 'Java EE', null, 'written test');
insert into exams(name, starting_time, duration, bibliography, are_teams_allowed, exam_type)
values ('Android Technologies', '2021-11-17 13:30', 0.5, null, false, 'project presentation');
insert into exams(name, starting_time, duration, bibliography, are_teams_allowed, exam_type)
values ('Machine Learning', '2021-11-20 12:00', 3, null, true, 'project presentation');

insert into students(name)
values ('Mike');
insert into students(name)
values ('John');
insert into students(name)
values ('Roger');

insert into students_exams(student_id, exam_id)
values (1, 1);
insert into students_exams(student_id, exam_id)
values (1, 2);
insert into students_exams(student_id, exam_id)
values(1, 4);
insert into students_exams(student_id, exam_id)
values(2, 1);
insert into students_exams(student_id, exam_id)
values(2, 3);
insert into students_exams(student_id, exam_id)
values(3, 2);
insert into students_exams(student_id, exam_id)
values(3, 3);
insert into students_exams(student_id, exam_id)
values(3, 4);