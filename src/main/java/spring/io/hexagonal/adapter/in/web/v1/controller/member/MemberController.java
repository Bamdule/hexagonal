package spring.io.hexagonal.adapter.in.web.v1.controller.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver.MemberToken;
import spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver.MemberTokenInfo;
import spring.io.hexagonal.adapter.in.web.v1.controller.common.ApiResponse;
import spring.io.hexagonal.application.port.in.member.FindMemberInfo;
import spring.io.hexagonal.application.port.in.member.FindMemberUseCaseInPort;
import spring.io.hexagonal.application.port.in.member.RegisterMemberInfo;
import spring.io.hexagonal.application.port.in.member.RegisterMemberUseCaseInPort;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/members")
@RestController
public class MemberController {

	private final FindMemberUseCaseInPort findMemberUseCase;
	private final RegisterMemberUseCaseInPort registerMemberUseCase;

	@GetMapping("/{memberId}")
	public ResponseEntity<ApiResponse<FindMemberResponse>> findMember(
		@PathVariable(value = "memberId") Long memberId,
		@MemberToken MemberTokenInfo memberTokenInfo
	) {
		FindMemberInfo findMemberInfo = findMemberUseCase.findById(memberId);
		log.info("memberTokenInfo : {}", memberTokenInfo);

		return ResponseEntity.ok(ApiResponse.success(FindMemberResponse.from(findMemberInfo)));
	}

	@PostMapping
	public ResponseEntity<ApiResponse<RegisterMemberResponse>> findMember(
		@RequestBody @Valid RegisterMemberRequest request) {
		RegisterMemberInfo registerMemberInfo = registerMemberUseCase.register(request.to());
		return ResponseEntity.ok(ApiResponse.success(RegisterMemberResponse.from(registerMemberInfo)));
	}
}
