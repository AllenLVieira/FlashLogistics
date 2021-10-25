create table delivery(
	id bigint not null auto_increment,
	client_id bigint not null,
	fee decimal(13,2) not null,
	status varchar(20) not null,
	request_date datetime not null,
	delivery_date datetime,
	
	receiver_name varchar(30) not null, 
	receiver_address varchar(255) not null,
	receiver_address_number varchar(10) not null,
	receiver_address_complement varchar(20),
	receiver_district varchar(20) not null,
	
	primary key(id)
);

alter table delivery add constraint fk_delivery_client foreign key(client_id) references client (id);