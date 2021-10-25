package br.com.allen.flashlogistics.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.allen.flashlogistics.domain.exception.BusinessException;
import br.com.allen.flashlogistics.domain.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;

@ControllerAdvice
@AllArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Errors errors = new Errors();
		List<Errors.Fields> fields = new ArrayList<>();
		for (ObjectError error: ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String msg = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			fields.add(new Errors.Fields(name, msg));
		}
		errors.setStatus(status.value());
		errors.setDateTime(OffsetDateTime.now());
		errors.setTitle("One or more fields are invalid. Please send correctly.");
		errors.setFields(fields);
		return handleExceptionInternal(ex, errors, headers, status, request);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Errors errors = new Errors();
		errors.setStatus(status.value());
		errors.setTitle(ex.getMessage());
		errors.setDateTime(OffsetDateTime.now());
		return handleExceptionInternal(ex, errors, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		Errors errors = new Errors();
		errors.setStatus(status.value());
		errors.setTitle(ex.getMessage());
		errors.setDateTime(OffsetDateTime.now());
		return handleExceptionInternal(ex, errors, new HttpHeaders(), status, request);
	}
}
