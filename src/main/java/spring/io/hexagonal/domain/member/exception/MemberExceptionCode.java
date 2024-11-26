package spring.io.hexagonal.domain.member.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import spring.io.hexagonal.domain.common.exception.ExceptionCode;

@RequiredArgsConstructor
@Getter
public enum MemberExceptionCode implements ExceptionCode {
	NOT_FOUND("존재하지 않는 회원입니다.");

	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
