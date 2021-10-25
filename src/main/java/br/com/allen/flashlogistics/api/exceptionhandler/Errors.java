package br.com.allen.flashlogistics.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Errors {
	private Integer status;
	private OffsetDateTime dateTime;
	private String title;
	private List<Fields> fields;
	
	@Getter
	@AllArgsConstructor
	public static class Fields{
		private String field;
		private String problem;
	}
}
