create table pessoa (
	ID bigint(20) primary key auto_increment,
	nome varchar(150) not null,
	email varchar(80) not null unique key,
	cpf varchar(11) not null unique key,
	data_nascimento date not null
	
) engine=InnoDB default charset=utf8;

insert into pessoa (nome, email, cpf, data_nascimento) values ('Erika Ferra Conca', 'erikafc@gmail.com', '02147091178', '1988-03-21');
insert into pessoa (nome, email, cpf, data_nascimento) values ('Renan morais', 'renancm@gmail.com', '01494037176', '1987-02-28');