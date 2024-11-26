package spring.io.hexagonal.domain.member.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Member {

	private Long id;
	private String name;

	public static Member create(String name) {
		return new Member(null, name);
	}

	public static Member from(Long id, String name) {
		return new Member(id, name);
	}
}
