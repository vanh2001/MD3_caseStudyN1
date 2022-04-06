create database LibraryManagement;
use LibraryManagement;

create table user(
                     id_user int auto_increment primary key,
<<<<<<< HEAD
                     name_of_user nvarchar(80) not null,
                     date_of_birth date not null primary key ,
                     email_user varchar(60) unique ,
=======
                     name_of_user varchar(80) not null,
                     email_user varchar(80) not null,
                     password_user varchar(60),
>>>>>>> quanLe
                     phone_number int(12)
);
insert into user ( name_of_user, date_of_birth, email_user, phone_number) value ("Nguyễn Thị Hoa",'1998/5/13',"hoa@gmail.com",123456);
insert into user ( name_of_user, date_of_birth, email_user, phone_number) value ("Nguyễn Minh Đức",'1993/6/13',"duc@gmail.com",147258);
insert into user ( name_of_user, date_of_birth, email_user, phone_number) value ("Nguyễn Thu Thủy",'1994/5/20',"hoa@gmail.com",154588);
insert into user ( name_of_user, date_of_birth, email_user, phone_number) value ("Nguyễn Văn Việt",'1998/5/13',"hoa@gmail.com",122863);
select * from user;
create table book(
                     id_book int auto_increment primary key,
                     name_of_book nvarchar(60) not null,
                     author nvarchar (50),
                     book_description nvarchar(60),
                     book_status bit ,
                     book_amount int,
                     book_kind nvarchar(60),
                     book_publishing nvarchar(50)
);
insert into book( name_of_book,author, book_description, book_status, book_amount, book_kind, book_publishing)
 value ("Hoàng tử bé","Le Petit Prince","Nước ngoài",true ,10,"Văn học","1943");
insert into book( name_of_book,author, book_description, book_status, book_amount, book_kind, book_publishing)
value ("Nhà giả kim","O Alquimista","Nước ngoài",true ,15,"Kỹ năng","1989");
insert into book( name_of_book,author, book_description, book_status, book_amount, book_kind, book_publishing)
value ("Dế mèn phiêu lưu kí","Tô Hoài","Trong nước",true ,20,"Văn học","1974");
insert into book( name_of_book,author, book_description, book_status, book_amount, book_kind, book_publishing)
    value ("1001 câu hỏi vì sao","Chung Thiệu","Trong nước",true ,5,"Sách thiếu nhi","1998");
select * from book;
create table customersBorrowBooks(
                                     id_customer_book int auto_increment primary key,
<<<<<<< HEAD
                                     name_of_user nvarchar(80),
                                     customer_address nvarchar(120),
                                     customer_birthday DATE,
                                     id_book int,
                                     foreign key (name_of_user) references user(name_of_user),
                                     foreign key (id_book) references book(id_book),
                                     foreign key (customer_birthday)references user(date_of_birth)
=======
                                     id_user int,
                                     customer_address varchar(120),
                                     customer_birthday DATE,
                                     id_book int,
                                     foreign key (id_user) references user(id_user),
                                     foreign key (id_book) references book(id_book)
);
>>>>>>> 3011a43f32dba27ad3613d894e207a3eede37ac9

);
insert into customersBorrowBooks( name_of_user, customer_address, customer_birthday, id_book)
values ("Nguyễn Thị Hoa","Hà Nội",'1998/5/13',2);
insert into customersBorrowBooks( name_of_user, customer_address, customer_birthday, id_book)
values ("Nguyễn Minh Đức","Hải Phòng",'1993/6/13',1);
insert into customersBorrowBooks( name_of_user, customer_address, customer_birthday, id_book)
values ("Nguyễn Thu Thủy","Đà Nẵng",'1994/5/20',2);
select * from customersBorrowBooks;
create table loanSlip(
                         id_loan_slip int auto_increment primary key,
                         on_loan_status bit ,
                         out_of_date date,
                         returned_the_book varchar(60),
                         id_book int,
                         id_user int,
                         foreign key (id_book) references book(id_book),
                         foreign key (id_user) references user(id_user)
);
insert into loanSlip(on_loan_status, out_of_date, returned_the_book, id_book, id_user)
value (true ,'2022/1/10','2022/1/15', 2,1);
insert into loanSlip(on_loan_status, out_of_date, returned_the_book, id_book, id_user)
    value (true ,'2022/2/1','2022/2/15', 1,2);
insert into loanSlip(on_loan_status, out_of_date, returned_the_book, id_book, id_user)
    value (true ,'2022/1/20','2022/2/1', 2,3);

create table librarian(
    id_librarian int primary key not null ,
    name varchar (50),
    id_user int,
    id_customersBorrowBook int,
    id_loanSlip int,
    foreign key (id_user) references user(id_user),
    foreign key (id_customersBorrowBook) references customersBorrowBooks(id_customer_book),
    foreign key (id_loanSlip) references loanSlip(id_loan_slip)
)

create table admin(
                      id_admin int auto_increment primary key,
                      name_admin varchar(60),
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
