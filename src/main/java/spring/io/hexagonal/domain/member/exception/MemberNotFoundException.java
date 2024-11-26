package spring.io.hexagonal.domain.member.exception;

import lombok.Getter;
import spring.io.hexagonal.domain.common.exception.DomainBusinessException;
import spring.io.hexagonal.domain.common.exception.ExceptionCode;

@Getter
public class MemberNotFoundException extends DomainBusinessException {

	public MemberNotFoundException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}
}
