package br.com.allen.flashlogistics.domain.exception;

public class BusinessException extends RuntimeException{
	private static final long serialVersionUID = -1973646420564458725L;
	public BusinessException(String message) {
		super(message);
	}
}
