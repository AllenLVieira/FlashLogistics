create table client(
	id bigint not null auto_increment,
	name varchar(30) not null,
	email varchar(80) not null,
	phone varchar(20) not null,
	
	primary key (id)
);