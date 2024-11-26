package spring.io.hexagonal.application.port.in.member;

import spring.io.hexagonal.domain.member.entity.Member;

public record RegisterMemberInfo(Long id) {

	public static RegisterMemberInfo to(Member member) {
		return new RegisterMemberInfo(member.getId());
	}
}
