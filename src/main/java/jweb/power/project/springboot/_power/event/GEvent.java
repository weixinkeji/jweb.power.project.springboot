package jweb.power.project.springboot._power.event;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixinkeji.vip.jweb.power.event.JWPGlobalEvent;

public class GEvent implements JWPGlobalEvent {
	@Override
	public boolean jwpGlobal(final FilterChain chain, final HttpServletRequest req, final HttpServletResponse resp,
			final String requestURL) throws IOException, ServletException {
		System.out.println("全局事件");
		return true;
	}
	
}
