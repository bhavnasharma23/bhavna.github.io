# bhavna.github.io
Hi,
I have completed my all the assignment comprises of 3 questions.

1. Web Application :- 
I have build the web-application using java EE , JDBC , mysql DB, html, jsp pages.
How to start the application.
:-

Before running the application. Following are the steps to be taken care :- 
1. Create the db :- employeedb
2. create the table- employee 
DML :- +--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| emailAddress | varchar(255) | NO   |     | NULL    |                |
| firstName    | varchar(255) | NO   |     | NULL    |                |
| lastName     | varchar(255) | NO   |     | NULL    |                |
| password     | varchar(8)   | NO   |     | NULL    |                |
| userName     | varchar(20)  | NO   |     | NULL    |  Primary key              |
| phoneno      | int(11)      | YES  |     | NULL    |                |
| location     | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
I have considered username as primary key. Two employee can not have same username.

3. create the mysql connection string. In my case I am running in my local 
    mysql connection string :-   connectionUrl=jdbc:mysql://localhost:3306/employeedb
    All properties are being maintained in db.properties.
    
properties :- 
dbDriver=com.mysql.jdbc.Driver
connectionUrl=jdbc:mysql://localhost:3306/employeedb
userName=root
password=


4. Deploy the folder EmployeeDBMS from the repository. 

Please find EmployeeWebApplication doc file. I have attached the screen shots for my application.




Question 2:- 
Please find folder for question 2 . 

Question No. 2) Write a function which will returns the maximum number of words in a sentence. Given text can be divided into sentences by splitting it at dots, question marks and exclamation marks. For example, given S= "We test coders. Give us a try?", the function should return 4.

Solution :- I have attched my java file. It is giving expected output for me.


Question 3:- 

Question No. 3) Suppose you have 2 tables as below
I. Employee(EmpNo(PK), Ename, Job, MGR, Hiredate, Salary, DeptNo)                                                                                                                                                                                           II. Department(DeptNo(PK), Dname, Location)                                                                                  
Write a query that shows department name and total number of employees in each department with the format as DEPTPARTMENT NAME:NUMBER OF EMPLOYEE

Solution :- 

I have attched doc file for my solution to the folder question-3. I have mentioned the create tables Department and Employee.
And the query which shows department name and total number of employees in each department with the format as DEPTPARTMENT NAME:NUMBER OF EMPLOYEE.
