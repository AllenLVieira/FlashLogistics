package br.com.allen.flashlogistics.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcurrenceResponse {
	private Long id;
	private String description;
	private OffsetDateTime ocurrenceDate;
}
