DROP DATABASE IF EXISTS students;
 
CREATE DATABASE students DEFAULT CHARACTER SET 'utf8';
 
USE students;
 
create table groups
(
  group_id int unsigned not null auto_increment,
  groupName varchar(255) not null,
  curator varchar(255) not null,
  speciality varchar(255) not null,
  primary key (group_id)
) engine=InnoDB;
 
create table students
(
  student_id int unsigned not null auto_increment,
  firstName varchar(255) not null,
  surName varchar(255) not null,
  patronymic varchar(255) not null,
  dateOfBirth date not null,
  sex char(1),
  group_id int not null,
  educationYear int not null,
  primary key (student_id)
) engine=InnoDB;
 
set names 'utf8';
 
insert into groups (groupName, curator, speciality) 
values ('first-group', 'doctor', 'health');
insert into groups (groupName, curator, speciality) 
values ('second-group', 'professor', 'phisics');
 
insert into students (firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)
values ('Ivan', 'S', 'Stepanov', 'm', '1990-03-20', 1, 2006);
 
insert into students (firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)
values ('Natalia', 'M', 'Chichik', 'f', '1990-06-10', 1, 2006);
 
insert into students (firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)
values ('Victor', 'A', 'Belov', 'm', '1990-01-10', 1, 2006);
 
insert into students (firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)
values ('Petr', 'B', 'Sushkina', 'm', '1991-03-12', 2, 2006);
 
insert into students (firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)
values ('Veronika', 'C', 'Kovaleva', 'f', '1991-07-19', 2, 2006);
 
insert into students (firstName, patronymic, surName, sex, dateOfBirth, group_id, educationYear)
values ('Irina', 'F', 'Istomina', 'f', '1991-04-29', 2, 2006);