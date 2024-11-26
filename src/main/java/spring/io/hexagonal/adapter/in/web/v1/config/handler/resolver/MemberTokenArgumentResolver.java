package spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MemberTokenArgumentResolver implements HandlerMethodArgumentResolver {
	private final MemberTokenHolder memberTokenHolder;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().equals(MemberTokenInfo.class) && parameter.hasParameterAnnotation(MemberToken.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
		return memberTokenHolder.getMemberTokenInfo();
	}
}
