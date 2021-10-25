package br.com.allen.flashlogistics.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OcurrenceRequest {
	@NotBlank
	private String description;
}
