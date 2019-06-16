package jweb.power.project.springboot._power.event;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixinkeji.vip.jweb.power.event.JWPGlobalEvent;

public class MyJWPGlobalEvent implements JWPGlobalEvent {

	@Override
	public boolean jwpGlobal(final FilterChain chain, final HttpServletRequest req, final HttpServletResponse resp,
			final String requestURL) throws IOException, ServletException {
//		System.out.println("我是全局事件");
		//当我们需要自行放行一些路径时， 我们可以返回false;
		//然后使用 chain，手动放行路径
//		if(requestURL.equals("/")) {
//			chain.doFilter(req, resp);//强制手动放行
//			return false;
//		}
		return true;
	}
}
