package spring.io.hexagonal.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
