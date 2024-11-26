package spring.io.hexagonal.application.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import spring.io.hexagonal.application.port.in.member.FindMemberInfo;
import spring.io.hexagonal.application.port.out.member.MemberOutPort;
import spring.io.hexagonal.domain.member.entity.Member;

@ExtendWith(MockitoExtension.class)
class FindMemberUseCaseTest {

	@Mock
	public MemberOutPort memberOutPort;

	@InjectMocks
	public FindMemberUseCase findMemberUseCase;

	@DisplayName("회원 조회 성공")
	@Test
	void 회원_조회_성공() {

		// given
		long id = 1L;
		String name = "kim";

		when(memberOutPort.findById(any())).thenReturn(Optional.of(Member.from(id, name)));

		// when
		FindMemberInfo findMemberInfo = findMemberUseCase.findById(id);

		// then
		Assertions.assertThat(findMemberInfo).isNotNull();
		Assertions.assertThat(findMemberInfo.id()).isEqualTo(id);
		Assertions.assertThat(findMemberInfo.name()).isEqualTo(name);
	}

}