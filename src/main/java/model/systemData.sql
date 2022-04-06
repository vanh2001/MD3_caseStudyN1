create database LibraryManagement;
use LibraryManagement;

create table user(
                     id_user int auto_increment primary key,
                     name_of_user varchar(80) not null,
                     email_user varchar(80) not null,
                     password_user varchar(60),
                     phone_number int(12)
);

create table book(
                     id_book int auto_increment primary key,
                     name_of_book varchar(60) not null,
                     book_description varchar(60),
                     book_status varchar(60),
                     book_amount int,
                     book_kind varchar(60),
                     book_publishing varchar(50)
);

create table customersBorrowBooks(
                                     id_customer_book int auto_increment primary key,
                                     id_user int,
                                     customer_address varchar(120),
                                     customer_birthday DATE,
                                     id_book int,
                                     foreign key (id_user) references user(id_user),
                                     foreign key (id_book) references book(id_book)
);

create table loanSlip(
                         id_loan_slip int auto_increment primary key,
                         on_loan_status varchar(60),
                         out_of_date date,
                         returned_the_book varchar(60),
                         id_book int,
                         id_user int,
                         foreign key (id_book) references book(id_book),
                         foreign key (id_user) references user(id_user)
);

create table admin(
                      id_admin int auto_increment primary key,
                      name_admmin varchar(60),
                      phone_admin varchar(12),
                      id_book int,
                      id_user int,
                      foreign key (id_book) references book(id_book),
                      foreign key (id_user) references user(id_user)
);

create table LibrarianBean(
    id_librarian_bean int auto_increment primary key,
    name_librarian_bean varchar(60),
    email_librabian_bean varchar(60),
    phone_number_librabian varchar(12)
);
