create table courses(
  id int not null AUTO_INCREMENT,
  name varchar(100) not null,
  description varchar(100) not null,
  is_active boolean not null,
  PRIMARY KEY ( id )
);