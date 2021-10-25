package br.com.allen.flashlogistics.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequest {
	@Valid
	@NotNull
	private ClientIdInput client;
	
	@Valid
	@NotNull
	private ReceiverInput receiver;
	
	@NotNull
	private BigDecimal fee;
}
