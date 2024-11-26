package spring.io.hexagonal.adapter.out.persistence.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.io.hexagonal.domain.member.entity.Member;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "member")
@Entity
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	public static MemberEntity from(Member member) {
		return new MemberEntity(member.getId(), member.getName());
	}

	public Member to() {
		return Member.from(this.id, this.name);
	}
}
