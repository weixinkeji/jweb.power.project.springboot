package jweb.power.project.springboot._power.listen;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.power.project.springboot.entity.User;
import weixinkeji.vip.jweb.power.listen.JWPListenInterface;
import weixinkeji.vip.jweb.power.listen.ListenStatus;
import weixinkeji.vip.jweb.power.model.JWPControllerModel;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

public class YearListen implements JWPListenInterface {
	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		if (status == ListenStatus.code_fail) {// 没有权限时，判断用户是否包年了
			// 用户必定登陆，请看我们登陆代码
			User obj = (User) req.getSession().getAttribute("userSession");
			if (null!=obj.getVipYear()&&obj.getVipYear() > 0) {// 开了包年或包月
				chain.doFilter(req, resp);//手动放行！
				return false;
			}
			return false;// 没有编号权限，又没有包年或包月。直接中止
		}
		return true;
	}

}
