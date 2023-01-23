-- 1
CREATE TABLE IF NOT EXISTS userdetails
(
    id serial primary key,
    street text ,
    colony text,
    city text,
    state text,
    pincode text,
    country text
)
--2
CREATE TABLE IF NOT EXISTS roles
(
    id serial primary key,
    role text
)
--3
CREATE TABLE IF NOT EXISTS users
(
    id serial primary key,
    username text ,
    firstname text,
    lastname text,
    pass_word text NOT NULL,
    userdetail_id integer,
    role_id integer,
    foreign key (userdetail_id) references userdetails(id),
    foreign key (role_id) references roles(role_id)
)

--4
create table categories(
    id serial primary key,
    category text
)

--5

create table productDetails(
    id serial primary key,
    product_code text,
    seller_id int,
    foreign key (seller_id) references sellerdetails(id)
)

--6
alter table productdetails add constraint prod_uniq_const unique (product_code);

--7
create table seller_product(
    id serial primary key,
    seller_code int,
    product_code text,
    foreign key (seller_code) references sellerdetails(id),
    foreign key (product_code) references productdetails(product_code)

)

--8

create table product(
    id serial primary key,
    product_name text,
    product_code text,
    product_id int,
    category_id int,
    foreign key (category_id) references categories(id),
    foreign key (product_code) references productdetails(product_code),
    foreign key (product_id) references sellerdetails(id)

)

--9
create table cart(
    id serial primary key,
    user_id int
)
--10
create table category_product_code(
    id serial primary key,
    category_id int,
    product_code text,
    foreign key (category_id) references categories(id),
    foreign key (product_code) references productdetails(product_code),
    foreign key (product_id) references sellerdetails(id)

)

--11
create table cart_product(
    id serial primary key,
    cart_id int,
    product_code text
)