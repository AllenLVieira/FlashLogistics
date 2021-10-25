package br.com.allen.flashlogistics.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.allen.flashlogistics.domain.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryResponse {
	private Long id;
	private String clientName;
	private ReceiverResponse receiver;
	private BigDecimal fee;
	private DeliveryStatus status;
	private OffsetDateTime requestDate;
	private OffsetDateTime deliveryDate;
}
