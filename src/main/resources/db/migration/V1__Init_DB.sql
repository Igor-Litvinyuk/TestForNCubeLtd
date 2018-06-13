create table person (
  id bigint not null auto_increment,
  date_of_birth varchar(255),
  filename varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  postal_code varchar(255),
  primary key (id)
);