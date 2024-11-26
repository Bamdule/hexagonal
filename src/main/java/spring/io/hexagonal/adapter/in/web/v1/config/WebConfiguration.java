package spring.io.hexagonal.adapter.in.web.v1.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import spring.io.hexagonal.adapter.in.web.v1.config.handler.interceptor.MemberTokenAuthorizationInterceptor;
import spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver.MemberTokenArgumentResolver;

@RequiredArgsConstructor
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	private final List<String> excludePathPatterns = Arrays.asList("", "");
	private final MemberTokenAuthorizationInterceptor memberTokenHandlerInterceptor;
	private final MemberTokenArgumentResolver memberTokenArgumentResolver;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(memberTokenHandlerInterceptor)
			.excludePathPatterns(excludePathPatterns);

	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(memberTokenArgumentResolver);
	}
}
