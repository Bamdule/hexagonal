package spring.io.hexagonal.application.usecase;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.io.hexagonal.application.port.in.member.FindMemberInfo;
import spring.io.hexagonal.application.port.in.member.FindMemberUseCaseInPort;
import spring.io.hexagonal.application.port.out.member.MemberOutPort;
import spring.io.hexagonal.domain.member.entity.Member;
import spring.io.hexagonal.domain.member.exception.MemberExceptionCode;
import spring.io.hexagonal.domain.member.exception.MemberNotFoundException;

@RequiredArgsConstructor
@Service
public class FindMemberUseCase implements FindMemberUseCaseInPort {
	private final MemberOutPort memberOutPort;

	@Override
	public FindMemberInfo findById(Long id) {
		Member member = memberOutPort.findById(id)
			.orElseThrow(() -> new MemberNotFoundException(MemberExceptionCode.NOT_FOUND));

		return FindMemberInfo.to(member);
	}
}
