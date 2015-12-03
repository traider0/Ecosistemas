CREATE TABLE employees (
    emp_no      INT             NOT NULL,
    birth_date  DATE            NOT NULL,
    first_name  VARCHAR(14)     NOT NULL,
    last_name   VARCHAR(16)     NOT NULL,
    gender      ENUM ('M','F')  NOT NULL,
    hire_date   DATE            NOT NULL,
    PRIMARY KEY (emp_no)
);

CREATE TABLE departments (
    dept_no     CHAR(4)         NOT NULL,
    dept_name   VARCHAR(40)     NOT NULL,
    PRIMARY KEY (dept_no),
    UNIQUE  KEY (dept_name)
);

CREATE TABLE dept_manager (
   dept_no      CHAR(4)         NOT NULL,
   emp_no       INT             NOT NULL,
   from_date    DATE            NOT NULL,
   to_date      DATE            NOT NULL,
   KEY         (emp_no),
   KEY         (dept_no),
   FOREIGN KEY (emp_no)  REFERENCES employees (emp_no)    ON DELETE CASCADE,
   FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
   PRIMARY KEY (emp_no,dept_no)
);

insert into `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) 
values(100, '1998-12-12', 'Ana', 'Gil', 'F', '2005-10-01');
insert into `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) 
values(200, '1978-10-10', 'Pablo', 'Lopez', 'M', '2007-05-01');
insert into `employees` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) 
values(300, '1968-2-12', 'Angel', 'Martin', 'M', '2009-10-21');

insert into `departments` (`dept_no`, `dept_name`) values('1000', 'IT');
insert into `departments` (`dept_no`, `dept_name`) values('2000', 'MARKETING');
insert into `departments` (`dept_no`, `dept_name`) values('3000', 'BILLING');

insert into `dept_manager` (`dept_no`, `emp_no`, `from_date`, `to_date`) values('1000', 100, '2010-10-10', '2011-10-10');
insert into `dept_manager` (`dept_no`, `emp_no`, `from_date`, `to_date`) values('2000', 200, '2012-01-01', '2013-01-01');

