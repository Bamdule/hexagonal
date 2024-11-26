package spring.io.hexagonal.adapter.in.web.v1.controller.member;

import spring.io.hexagonal.application.port.in.member.FindMemberInfo;

public record FindMemberResponse(Long id, String name) {

	public static FindMemberResponse from(FindMemberInfo findMemberInfo) {
		return new FindMemberResponse(findMemberInfo.id(), findMemberInfo.name());
	}
}
