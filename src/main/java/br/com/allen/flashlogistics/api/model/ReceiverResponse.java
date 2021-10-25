package br.com.allen.flashlogistics.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiverResponse {
	private String name;
	private String address;
	private String number;
	private String complement;
	private String district;
}
