set foreign_key_checks = 0;

delete from estado;
delete from cidade;
delete from categoria_evento;

set foreign_key_checks = 1;

alter table estado auto_increment = 1;
alter table cidade auto_increment = 1;
alter table categoria_evento auto_increment = 1;

insert into estado (id, sigla, nome) values (1, 'SG', 'Minas Gerais');
insert into estado (id, sigla, nome) values (2, 'SG', 'São Paulo');
insert into estado (id, sigla, nome) values (3, 'SG', 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into categoria_evento (id, nome,descricao) values (1, 'Palestra', '');
insert into categoria_evento (id, nome,descricao) values (2, 'Curso', '');
