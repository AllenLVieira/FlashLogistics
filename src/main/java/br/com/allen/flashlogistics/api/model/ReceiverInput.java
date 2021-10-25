package br.com.allen.flashlogistics.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiverInput {
	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String number;
	
	private String complement;
	
	@NotBlank
	private String district;
}
