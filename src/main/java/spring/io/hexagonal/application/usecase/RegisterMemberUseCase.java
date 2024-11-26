package spring.io.hexagonal.application.usecase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.io.hexagonal.application.port.in.member.RegisterMemberCommand;
import spring.io.hexagonal.application.port.in.member.RegisterMemberInfo;
import spring.io.hexagonal.application.port.in.member.RegisterMemberUseCaseInPort;
import spring.io.hexagonal.application.port.out.member.MemberOutPort;
import spring.io.hexagonal.domain.member.entity.Member;

@RequiredArgsConstructor
@Service
public class RegisterMemberUseCase implements RegisterMemberUseCaseInPort {
	private final MemberOutPort memberOutPort;

	@Override
	public RegisterMemberInfo register(RegisterMemberCommand command) {
		Member member = memberOutPort.save(command.to());
		return RegisterMemberInfo.to(member);
	}
}
