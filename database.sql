create table Exam
(
  crs char(8) not null,
  date date not null,
  location varchar(64) not null,
  status tinyint default '0' not null,
  dpm char(8) not null,
  primary key (dpm, crs)
)character set utf8
;

create index exam_course_crs_id_fk
  on Exam (crs)
;

create table Teacher
(
  tch_id varchar(8) not null
    primary key,
  name varchar(32) not null,
  password varchar(32) not null,
  email varchar(64) null,
  address varchar(128) null,
  phone varchar(13) not null,
  birthday date not null,
  gender tinyint(1) default '0' not null,
  biography varchar(128) null,
  tch_status tinyint default '1' not null,
  dpm_id char(8) not null,
  constraint teacher_tch_id_uindex
  unique (tch_id)
)character set utf8
;

create index teacher_department_dpm_id_fk
  on Teacher (dpm_id)
;

create table appeal
(
  dpm_id char(8) not null,
  crs_id char(8) not null,
  tch_id char(8) not null,
  stu_id char(8) not null,
  date date not null,
  content varchar(128) not null,
  response varchar(128) null,
  status tinyint default '0' not null,
  primary key (dpm_id, crs_id, tch_id, stu_id, date),
  constraint appeal_teacher_tch_id_fk
  foreign key (tch_id) references ssmis.teacher (tch_id)
)character set utf8
;

create index appeal_course_crs_id_fk
  on appeal (crs_id)
;

create index appeal_student_stu_id_fk
  on appeal (stu_id)
;

create index appeal_teacher_tch_id_fk
  on appeal (tch_id)
;

create table comment
(
  dpm char(8) not null,
  crs char(8) not null,
  tch char(8) not null,
  date date not null,
  content varchar(128) not null,
  primary key (dpm, tch, crs, date),
  constraint comment_teacher_tch_id_fk
  foreign key (tch) references ssmis.teacher (tch_id)
)character set utf8
;

create index comment_course_crs_id_fk
  on comment (crs)
;

create index comment_teacher_tch_id_fk
  on comment (tch)
;

create table course
(
  crs_id char(8) not null
    primary key,
  crs_name varchar(64) not null,
  summarization varchar(128) null comment '简介',
  constraint course_crs_id_uindex
  unique (crs_id)
)character set utf8
;

alter table Exam
  add constraint exam_course_crs_id_fk
foreign key (crs) references ssmis.course (crs_id)
;

alter table appeal
  add constraint appeal_course_crs_id_fk
foreign key (crs_id) references ssmis.course (crs_id)
;

alter table comment
  add constraint comment_course_crs_id_fk
foreign key (crs) references ssmis.course (crs_id)
;

create table course_schedule
(
  dpm_id char(8) not null,
  crs_id char(8) not null,
  tch_id char(8) not null,
  type tinyint default '0' not null comment '课程类型',
  preriods tinyint default '0' not null,
  credit tinyint not null,
  term tinyint default '0' not null,
  primary key (dpm_id, tch_id, crs_id),
  constraint course_schedule_course_crs_id_fk
  foreign key (crs_id) references ssmis.course (crs_id),
  constraint course_schedule_teacher_tch_id_fk
  foreign key (tch_id) references ssmis.Teacher (tch_id)
)character set utf8
;

create index course_schedule_course_crs_id_fk
  on course_schedule (crs_id)
;

create index course_schedule_teacher_tch_id_fk
  on course_schedule (tch_id)
;

create table courses_table
(
  dpm_id char(8) not null,
  crs_id char(8) not null,
  tch_id char(8) not null,
  weeks varchar(60) default '0' null ,
  off varchar(20) default '0' null ,
  site varchar(20) not null ,
  primary key (crs_id, dpm_id, tch_id, site),
  constraint courses_table_course_crs_id_fk
  foreign key (crs_id) references ssmis.course (crs_id),
  constraint courses_table_Teacher_tch_id_fk
  foreign key (tch_id) references ssmis.Teacher (tch_id)
)character set utf8
;

create index courses_table_department_dpm_id_fk
  on courses_table (dpm_id)
;

create index courses_table_teacher_tch_id_fk
  on courses_table (tch_id)
;

create index courses_table_course_crs_id_fk
  on courses_table (crs_id)
;

create table department
(
  dpm_id char(8) not null
    primary key,
  dpm_name varchar(32) not null,
  constraint department_dpm_id_uindex
  unique (dpm_id),
  constraint department_dpm_name_uindex
  unique (dpm_name)
)character set utf8
;

alter table Exam
  add constraint exam_department_dpm_id_fk
foreign key (dpm) references ssmis.department (dpm_id)
;

alter table Teacher
  add constraint teacher_department_dpm_id_fk
foreign key (dpm_id) references ssmis.department (dpm_id)
;

alter table appeal
  add constraint appeal_department_dpm_id_fk
foreign key (dpm_id) references ssmis.department (dpm_id)
;

alter table comment
  add constraint comment_department_dpm_id_fk
foreign key (dpm) references ssmis.department (dpm_id)
;

alter table course_schedule
  add constraint course_schedule_department_dpm_id_fk
foreign key (dpm_id) references ssmis.department (dpm_id)
;

alter table courses_table
  add constraint courses_table_department_dpm_id_fk
foreign key (dpm_id) references ssmis.department (dpm_id)
;

create table student
(
  stu_id char(8) not null
    primary key,
  name varchar(32) not null,
  password varchar(32) not null,
  email varchar(64) null,
  address varchar(128) null,
  phone varchar(13) not null,
  birthday date not null,
  gender tinyint(1) default '0' not null,
  grade smallint(6) default '1' not null,
  class_no tinyint default '1' not null,
  stu_status tinyint default '1' null,
  photo_uri varchar(255) null,
  constraint student_stu_id_uindex
  unique (stu_id)
)character set utf8
;

alter table appeal
  add constraint appeal_student_stu_id_fk
foreign key (stu_id) references ssmis.student (stu_id)
;

create table student_schedule
(
  dpm char(8) not null,
  crs char(8) not null,
  tch char(8) not null,
  stu char(8) not null,
  term tinyint not null,
  score float default '0' not null,
  primary key (dpm, crs, tch, stu),
  constraint student_chedule_department_dpm_id_fk
  foreign key (dpm) references ssmis.department (dpm_id),
  constraint student_chedule_course_crs_id_fk
  foreign key (crs) references ssmis.course (crs_id),
  constraint student_schedule_Teacher_tch_id_fk
  foreign key (tch) references ssmis.Teacher (tch_id),
  constraint student_chedule_student_stu_id_fk
  foreign key (stu) references ssmis.student (stu_id)
)character set utf8
;

create index student_chedule_course_crs_id_fk
  on student_schedule (crs)
;

create index student_chedule_student_stu_id_fk
  on student_schedule (stu)
;

create index student_chedule_teacher_tch_id_fk
  on student_schedule (tch)
;


