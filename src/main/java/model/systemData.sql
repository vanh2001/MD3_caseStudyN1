create database LibraryManagement;
use LibraryManagement;

create table User(
                     id_user int auto_increment primary key,
                     name_of_user varchar(80) not null,
                     password_user varchar(60) not null,
                     email_user varchar(100),
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

create table LibrarianBean(
                      id_librabian int auto_increment primary key,
                      name_librabian varchar(60),
                      phone_librabian varchar(12),
                      idTitle int,
                      idUser int,
                      foreign key (idTitle) references TitleBook(id),
                      foreign key (idUser) references Customer(id)
);