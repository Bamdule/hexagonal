package spring.io.hexagonal.adapter.in.web.v1.config.handler.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring.io.hexagonal.adapter.in.web.v1.controller.common.ApiResponse;
import spring.io.hexagonal.domain.common.exception.DomainBusinessException;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(
		HttpMessageNotReadableException exception) {
		ExceptionResponse response = new ExceptionResponse(
			"요청 메시지가 잘못 되었습니다.",
			"HTTP_MESSAGE_NOT_READABLE"
		);

		return ResponseEntity.status(400).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<ExceptionResponse>> handleMethodArgumentNotValidException(
		MethodArgumentNotValidException exception) {

		List<ExceptionResponse.InvalidParameter> invalidParameters = exception.getBindingResult().getFieldErrors()
			.stream()
			.map(error -> new ExceptionResponse.InvalidParameter(
				error.getField(),
				error.getRejectedValue(),
				error.getDefaultMessage()
			))
			.toList();

		ExceptionResponse response = new ExceptionResponse(
			"잘못된 파라미터를 입력했습니다.",
			"INVALID_PARAMETERS",
			invalidParameters
		);

		return ResponseEntity.ok(ApiResponse.failure(response));
	}

	@ExceptionHandler(DomainBusinessException.class)
	public ResponseEntity<ApiResponse<ExceptionResponse>> handleDomainException(DomainBusinessException exception) {
		ExceptionResponse response = new ExceptionResponse(
			exception.getMessage(),
			exception.getExceptionCode().getCode()
		);

		return ResponseEntity.ok(ApiResponse.failure(response));
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ApiResponse<ExceptionResponse>> handleMissingServletRequestParameterException(
		MissingServletRequestParameterException exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(), "MISSING_PARAMETER");

		return ResponseEntity.ok(ApiResponse.failure(response));
	}

}
