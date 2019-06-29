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

public class Vip12GradesListen implements JWPListenInterface {
	private final String vipP12="vipP12";
	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		int vip = 12;
		if (status == ListenStatus.grades_success) {// 表示检验成功。用户必定拥有等级
			for (String grades : powerCode.grades) {
				if (vip <= Integer.parseInt(grades)) {// 你符合要求的会员

					User obj = (User) req.getSession().getAttribute("userSession");
					//判断用户是否已经买了vip12的专属礼包 
					if (null != obj.getVipPCode() && obj.getVipPCode().equals(vipP12)) {//
						return true;
					}
					
					return false;// 等级符合，但没有买我们的vip礼包
				}
			}
		}
		return false;
	}

}
