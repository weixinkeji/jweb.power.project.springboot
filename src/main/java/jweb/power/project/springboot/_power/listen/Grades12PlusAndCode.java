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

/**
 * 12级及以上的会员，并购买了 12级会员  专属vip礼包=   VIP12
 * 
 * @author wangchunzi
 *
 */
public class Grades12PlusAndCode implements JWPListenInterface {

	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		
		Object obj=req.getSession().getAttribute("userSession");
		if(null==obj) {//未登陆
			return false;
		}
		User user=(User)obj;
		
		if (status == ListenStatus.grades_success &&null!=user.getVipcode()&& user.getVipcode().equals("VIP12")) {
			for (String str : powerCode.grades) {
				if (12 <= Integer.parseInt(str)) {
					return true;
				}
			}
		}
		return false;
	}
}