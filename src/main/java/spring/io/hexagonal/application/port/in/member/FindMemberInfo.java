package spring.io.hexagonal.application.port.in.member;

import spring.io.hexagonal.domain.member.entity.Member;

public record FindMemberInfo(Long id, String name) {

	public static FindMemberInfo to(Member member) {
		return new FindMemberInfo(member.getId(), member.getName());
	}
}
