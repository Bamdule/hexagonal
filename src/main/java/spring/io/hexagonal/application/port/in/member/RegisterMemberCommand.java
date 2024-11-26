package spring.io.hexagonal.application.port.in.member;

import spring.io.hexagonal.domain.member.entity.Member;

public record RegisterMemberCommand(String name) {

	public Member to() {
		return Member.create(name);
	}
}
