#cascae example in SQL

create table employee(

empId char(5),
empName varchar(20),
empAddress varchar(20),

constraint pk_01 primary key (empId)
);

create table laptop(

serialNo char(10),
type varchar (20),
assignedEmp char(5),

constraint pk_02 primary key (serialNo),
constraint fk_01 foreign key (assignedEmp) references employee(empId) on delete cascade on update cascade
);

insert into employee values ('1000','Kasun','colombo');
insert into employee values ('2000','Madusanka','pannipitiya');
insert into employee values ('3000','chanaka','rathanapura');
insert into employee values ('4000','sanajaya','maharagama');
insert into employee values ('5000','shanika','walimada');


insert into laptop value ('0948322','Lenovo Think Pad','1000');
insert into laptop value ('4229238','Apple i mac','2000');
insert into laptop value ('7827727','Apple i mac','4000');
insert into laptop value ('3323232','Apple i mac','5000');
insert into laptop value ('4495950','DELL','3000');

select * from employee;
select * from laptop;

update employee set empId='8000' where empId='1000';
delete from employee where empId='5000';
