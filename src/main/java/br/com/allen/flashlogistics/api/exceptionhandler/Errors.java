package br.com.allen.flashlogistics.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Errors {
	private Integer status;
	private LocalDateTime dateTime;
	private String title;
	private List<Fields> fields;
	
	@Getter
	@AllArgsConstructor
	public static class Fields{
		private String field;
		private String problem;
	}
}
