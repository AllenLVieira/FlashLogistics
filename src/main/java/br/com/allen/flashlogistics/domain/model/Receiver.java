package br.com.allen.flashlogistics.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Receiver {
	@Column(name = "receiver_name")
	private String name;
	
	@Column(name = "receiver_address")
	private String address;
	
	@Column(name = "receiver_address_number")
	private String number;
	
	@Column(name = "receiver_address_complement")
	private String complement;
	
	@Column(name = "receiver_district")
	private String district;
}
