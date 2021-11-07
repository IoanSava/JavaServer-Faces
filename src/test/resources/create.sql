create table if not exists exams
(
    id                integer      not null generated always as identity,
    name              varchar(100) not null,
    starting_time     timestamp,
    duration          float,
    bibliography      varchar(200),
    are_teams_allowed bool,
    exam_type         varchar(100)         not null,
    primary key (id),
    check (exam_type = 'project presentation' or exam_type = 'written test')
);

create table if not exists students
(
    id   integer      not null generated always as identity,
    name varchar(100) not null,
    primary key (id)
);

create table if not exists students_exams
(
    student_id integer not null references students on delete restrict,
    exam_id    integer not null references exams on delete restrict,
    primary key (student_id, exam_id)
);

create table if not exists resources
(
    id                 integer      not null generated always as identity,
    name               varchar(100) not null,
    available_quantity integer      not null,
    primary key (id),
    check (available_quantity >= 0)
);