package jweb.power.project.springboot._power.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixinkeji.vip.jweb.power.event.JWPControllerURLPowerEvent;
import weixinkeji.vip.jweb.power.model.JWPControllerModel;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

public class ControllerEvent implements JWPControllerURLPowerEvent {

	@Override
	public boolean doOther_noController(HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPUserPower userPower) throws IOException, ServletException {
		System.out.println("-----------doOther_noController--------------");
		return false;
	}

	@Override
	public void doSessionPower_fail(HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel) throws IOException, ServletException {
//		resp.sendRedirect("https://nuwait.cn");
	}
}
