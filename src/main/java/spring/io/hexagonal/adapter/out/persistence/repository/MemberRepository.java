package spring.io.hexagonal.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import spring.io.hexagonal.application.port.out.member.MemberOutPort;
import spring.io.hexagonal.domain.member.entity.Member;

@RequiredArgsConstructor
@Repository
public class MemberRepository implements MemberOutPort {

	private final MemberJpaRepository memberJpaRepository;

	@Override
	public Optional<Member> findById(Long id) {
		return memberJpaRepository.findById(id)
			.map(MemberEntity::to);
	}

	@Override
	public Member save(Member member) {
		MemberEntity memberEntity = MemberEntity.from(member);
		return memberJpaRepository.save(memberEntity).to();
	}
}
