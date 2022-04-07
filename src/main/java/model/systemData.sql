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
                         id_customer int auto_increment primary key,
                         name_customer nvarchar(80) not null,
                         birth_customer date not null,
                         address_customer nvarchar(120),
                         email_customer nvarchar(60),
                         phoneNumber_customer int(12)
);

create table TitleBook(
                          id_title_book int auto_increment primary key,
                          name_title_book nvarchar(60)
);

create table Book(
                     id_book int auto_increment primary key,
                     id_title_book int,
                     name_book nvarchar(60) not null,
                     description_book nvarchar(60),
                     amount_book int,
                     kind_book nvarchar(60),
                     publishing_book nvarchar(50),
                     status_book varchar(60),
                     foreign key (id_title_book) references TitleBook(id_title_book)
);

create table ListCustomerBooks(
                                  id_list_customer int auto_increment primary key,
                                  id_customer int,
                                  address_list_customer nvarchar(120),
                                  birth_list_customer date,
                                  id_book int,
                                  foreign key (id_customer) references Customer(id_customer),
                                  foreign key (id_book) references Book(id_book)
);

create table LoanSlip(
                         id_loanSlip int auto_increment primary key,
                         borrowedDate_loan_slip date,
                         returnedDate_loan_slip date,
                         id_book int,
                         id_customer int,
                         foreign key (id_book) references Book(id_book),
                         foreign key (id_customer) references Customer(id_customer)
);

create table LoanSlipDetails(
                                id_detail int auto_increment primary key,
                                id_loanSlip int,
                                status_detail nvarchar(60),
                                foreign key (id_loanSlip) references LoanSlip(id_loanSlip)
);

create table LibrarianBean(
                      id_librarian_bean int auto_increment primary key,
                      name_librarian_bean varchar(60),
                      email_librabian_bean varchar(60),
                      password_librabian_bean varchar(20),
                      phone_librarian_bean varchar(12),
                      id_title_book int,
                      id_customer int,
                      foreign key (id_title_book) references TitleBook(id_title_book),
                      foreign key (id_customer) references Customer(id_customer)
);