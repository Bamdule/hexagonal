package spring.io.hexagonal.adapter.in.web.v1.config.handler.interceptor;

import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver.MemberTokenHolder;
import spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver.MemberTokenInfo;

@Component
@Slf4j
@RequiredArgsConstructor
public class MemberTokenAuthorizationInterceptor implements HandlerInterceptor {
	private final MemberTokenHolder memberTokenHolder;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		String uuid = UUID.randomUUID().toString();
		log.info("[authorize] authorization : {}", uuid);

		memberTokenHolder.setMemberTokenInfo(new MemberTokenInfo(uuid));

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
