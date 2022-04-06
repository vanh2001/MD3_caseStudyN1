create database LibraryManagement;
use LibraryManagement;

create table User(
                     id_user int auto_increment primary key,
                     name_of_user varchar(80) not null,
                     email_user varchar(80) not null,
                     password_user varchar(60),
                     phone_number int(12)
);

create table Customer(
                         id int auto_increment primary key,
                         name nvarchar(80) not null,
                         birth date not null,
                         address nvarchar(120),
                         email nvarchar(60),
                         phoneNumber int(12)
);

create table TitleBook(
                          id int auto_increment primary key,
                          name nvarchar(60)
);

create table Book(
                     id int auto_increment primary key,
                     idTitle int,
                     name nvarchar(60) not null,
                     description nvarchar(60),
                     amount int,
                     kind nvarchar(60),
                     publishing nvarchar(50),
                     status varchar(60),
                     foreign key (idTitle) references TitleBook(id)
);

create table ListCustomerBooks(
                                  id int auto_increment primary key,
                                  idUser int,
                                  address nvarchar(120),
                                  birth date,
                                  idBook int,
                                  foreign key (idUser) references Customer(id),
                                  foreign key (idBook) references Book(id)
);

create table LoanSlip(
                         id int auto_increment primary key,
                         borrowedDate date,
                         returnedDate date,
                         idBook int,
                         idUser int,
                         foreign key (idBook) references Book(id),
                         foreign key (idUser) references Customer(id)
);

create table LoanSlipDetails(
                                id int auto_increment primary key,
                                status nvarchar(60),
                                foreign key (id) references LoanSlip(id)
);

create table Admin(
                      id int auto_increment primary key,
                      name varchar(60),
                      phoneNumber varchar(12),
                      idBook int,
                      idUser int,
                      foreign key (idBook) references Book(id),
                      foreign key (idUser) references Customer(id)
);
insert into Customer(name, birth, address, email, phonenumber) values ('Do Hung Dung','1992/2/6','Ha Noi','dung@gmail.com','0967456328');
insert into Customer(name, birth, address, email, phonenumber) values ('Tran Van Nam','1994/6/6','Ha Nam','nam@gmail.com','0967456368');
select * from Customer;
select name,birth,address,email,phoneNumber from Customer;