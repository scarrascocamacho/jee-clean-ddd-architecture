insert into user (id, username, password, enabled) values (1, 'admin', '$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e', true);
insert into user (id, username, password, enabled) values (2, 'user', '$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e', true);

insert into authority (id, authority) values (1, 'ROLE_ADMIN');
insert into authority (id, authority) values (2, 'ROLE_USER');

insert into authorities_users values (1,1);
insert into authorities_users values (2,2);