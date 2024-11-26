package spring.io.hexagonal.domain.common.exception;

import lombok.Getter;

@Getter
public class DomainBusinessException extends RuntimeException {

	private final ExceptionCode exceptionCode;

	public DomainBusinessException(ExceptionCode exceptionCode) {
		super(exceptionCode.getMessage());
		this.exceptionCode = exceptionCode;
	}
}
