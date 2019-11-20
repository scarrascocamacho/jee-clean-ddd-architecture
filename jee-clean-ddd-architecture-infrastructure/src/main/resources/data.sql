DROP TABLE IF EXISTS roles;
 
CREATE TABLE roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL
);


insert into roles(id, username,description)
values(10001, 'user', 'Administrador');

insert into roles(id, username,description)
values(10002, 'user', 'Editor');

insert into roles(id, username,description)
values(10003, 'user', 'Consultor');