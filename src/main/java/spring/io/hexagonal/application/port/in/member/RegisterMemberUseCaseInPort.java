package spring.io.hexagonal.application.port.in.member;

public interface RegisterMemberUseCaseInPort {

	RegisterMemberInfo register(RegisterMemberCommand command);
}
