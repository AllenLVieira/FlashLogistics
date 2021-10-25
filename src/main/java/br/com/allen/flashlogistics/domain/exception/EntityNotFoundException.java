package br.com.allen.flashlogistics.domain.exception;

public class EntityNotFoundException extends BusinessException{

	private static final long serialVersionUID = -1225259549196957728L;

	public EntityNotFoundException(String message) {
		super(message);
	}
	
}
