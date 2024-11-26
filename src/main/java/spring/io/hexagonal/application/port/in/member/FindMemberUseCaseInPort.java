package spring.io.hexagonal.application.port.in.member;

public interface FindMemberUseCaseInPort {
	FindMemberInfo findById(Long id);
}
