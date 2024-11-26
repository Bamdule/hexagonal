package spring.io.hexagonal.adapter.in.web.v1.controller.member;

import spring.io.hexagonal.application.port.in.member.RegisterMemberInfo;

public record RegisterMemberResponse(Long id) {

	public static RegisterMemberResponse from(RegisterMemberInfo registerMemberInfo) {
		return new RegisterMemberResponse(registerMemberInfo.id());
	}
}
