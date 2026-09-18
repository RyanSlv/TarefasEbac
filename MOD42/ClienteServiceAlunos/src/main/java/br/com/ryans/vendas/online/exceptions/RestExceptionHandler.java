package br.com.ryans.vendas.online.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ryans.vendas.online.errorhandling.ApiError;
import jakarta.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";
		
		ApiError apiError = new ApiError(BAD_REQUEST);
		apiError.setMessage(error);
		
		return buildResponseEntity(apiError);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		StringBuilder builder =  new StringBuilder();
		
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		
		ex.getSupportedMediaTypes().forEach(type -> builder.append(type).append(", "));
		
		ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		
		if(builder.length() >= 2) {
			apiError.setMessage(builder.substring(0, builder.length() -2));
		}
		
		return buildResponseEntity(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ApiError apiError = new ApiError(BAD_REQUEST);
		
		apiError.setMessage("Validation error");
		
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());

        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		
        return buildResponseEntity(apiError);
	}
	
//	@Override
//	protected ResponseEntity<Object> handleBindException (BindException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		
//		ApiError apiError = new ApiError(BAD_REQUEST);
//		
//		apiError.setMessage(ex.getMessage());
//		
//		return buildResponseEntity(apiError);
//	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
		
		ApiError apiError = new ApiError(BAD_REQUEST);
		
		apiError.setMessage("Validation error");
		
		apiError.addValidationErrors(ex.getConstraintViolations());
		
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		
		ApiError apiError = new ApiError(NOT_FOUND);
		
		apiError.setMessage(ex.getMessage());
		
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequest(BadRequestException ex) {
		
		ApiError apiError = new ApiError(BAD_REQUEST);
		
		apiError.setMessage(ex.getMessage());
		
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	protected ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex) {
	
		ApiError apiError = new ApiError(BAD_REQUEST);
		
		apiError.setMessage("Registro duplicado");
		
		return buildResponseEntity(apiError);
		
	}
	
	@ExceptionHandler(UnsupportedOperationException.class)
	protected ResponseEntity<Object> handleUnsupportedOperationException(UnsupportedOperationException ex) {
		
		ApiError apiError = new ApiError(HttpStatus.UNPROCESSABLE_CONTENT);
		
		apiError.setMessage(ex.getMessage());
		
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
