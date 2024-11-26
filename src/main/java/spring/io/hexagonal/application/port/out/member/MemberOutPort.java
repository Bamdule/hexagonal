package spring.io.hexagonal.application.port.out.member;

import java.util.Optional;

import spring.io.hexagonal.domain.member.entity.Member;

public interface MemberOutPort {

	Optional<Member> findById(Long id);

	Member save(Member member);
}
