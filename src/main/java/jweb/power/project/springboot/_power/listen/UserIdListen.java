package jweb.power.project.springboot._power.listen;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.power.project.springboot.entity.User;
import weixinkeji.vip.jweb.power.ann.JWPRegListenUrl;
import weixinkeji.vip.jweb.power.listen.JWPListenInterface;
import weixinkeji.vip.jweb.power.listen.ListenStatus;
import weixinkeji.vip.jweb.power.model.JWPControllerModel;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

@JWPRegListenUrl(staticUrl = {"/static/_upload/image/"},staticSort = 1)
public class UserIdListen  implements JWPListenInterface {

	// 身份证 这个块，进行编号：id
	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		if(null==powerCode) {//未登陆
			return false;
		}
		//用户看自己的身份证
		Object obj=req.getSession().getAttribute("userSession");
//		if(null==obj) {//未登陆
//			return false;
//		}
		User user=(User)obj;
		if(user.getUserIdImg().equals(requestURL)) {//访问的身份证是自己的
			return true;
		}
		
		//这不是自己的身份证,又没有任何权限
		if(null==powerCode.code) {
			return false;
		}
		
		for(String code:powerCode.code) {
			if(code.equals("id")) {
				return true;//表示拥有访问权限。可以放行。
			}
		}
		return false;
	}
}