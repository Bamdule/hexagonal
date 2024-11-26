package spring.io.hexagonal.adapter.in.web.v1.config.handler.resolver;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class MemberTokenHolder {
	private MemberTokenInfo memberTokenInfo;
}