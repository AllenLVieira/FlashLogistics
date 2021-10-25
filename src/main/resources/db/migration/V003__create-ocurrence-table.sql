create table ocurrence(
	id bigint not null auto_increment,
	delivery_id bigint not null,
	description text not null,
	ocurrence_date datetime not null,
	
	primary key(id)
);

alter table ocurrence add constraint fk_ocurrence_delivery foreign key (delivery_id) references delivery (id);