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

//控制区：表达controllerUrl  排序controllerSort=0
//静态区：staticUrl:以前缀方式匹配， staticSort=0 排序
@JWPRegListenUrl(
		staticUrl = {"/static/_upload/image/"}
		)
public class UserIdListen implements JWPListenInterface {
	final String idCode="ids"; 
	//假如，我们的对这查看 身份的权限 进行编号，为 ids
	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		
		
		if(null==powerCode) {//用户未登陆
//			System.out.println("未登陆");
			return false;
		}
		//用户必定登陆，请看我们登陆代码
		User obj=(User)req.getSession().getAttribute("userSession");
		if(obj.getUserIdImg().equals(requestURL)) {//访问的是自己的图片
			return true;
		}
		//先检查是否有权限
		if(null==powerCode.code) {
			return false;
		}
		//检查用户是否有权限编号
		for(String code:powerCode.code) {
			if(code.equals(idCode)) {//如果有 访问身份证的 编号
				return true;
			}
		}
		return false;
	}

}
