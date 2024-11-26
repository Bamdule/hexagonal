package spring.io.hexagonal.adapter.in.web.v1.controller.member;

import jakarta.validation.constraints.NotBlank;
import spring.io.hexagonal.application.port.in.member.RegisterMemberCommand;

public record RegisterMemberRequest(
	@NotBlank(message = "name is required")
	String name
) {

	public RegisterMemberCommand to() {
		return new RegisterMemberCommand(name);
	}
}
