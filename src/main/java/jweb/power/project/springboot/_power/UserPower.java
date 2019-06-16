package jweb.power.project.springboot._power;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixinkeji.vip.jweb.power.config.JWPUserInterface;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

public class UserPower implements JWPUserInterface {

	@Override
	public JWPUserPower getUserPowerCode(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		Object obj=req.getSession().getAttribute("userPowerSession2");
		if(null==obj) {
			return null;//未登录
		}
		return (JWPUserPower)obj;
	}

}
