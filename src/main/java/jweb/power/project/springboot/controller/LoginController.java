package jweb.power.project.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jweb.power.project.springboot.entity.User;
import weixinkeji.vip.jweb.power.ann.JWPCommon;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

/**
 * 
 * @author wangchunzi
 *
 */

@JWPCommon
@Controller
public class LoginController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String forwardTAdd() {
		return "index";
	}
	
	@RequestMapping(path = "/user/{u}/login", method = RequestMethod.POST)
	public String forwardTAdd(HttpSession session,@PathVariable("u") Integer u, String sysGrades, String sysCodes) {
		User user=u==1
				?User.getUser1(sysCodes,sysGrades )		//u=1时	    ，返回模拟 用户1 的数据
				:User.getUser2(sysCodes,sysGrades );	//u=其他值时，返回模拟 用户2的数据
		//模拟 用户登陆		
		session.setAttribute("userSession", user);
		//顺带缓存一份权限。专门方便JWebPower取。这样不用每次JWebPower框架问我们要权限时，都来一次权限分析。
		addSession(session,user);
		
		return "index";
	}
	/**
	 * 分析用户权限，并用JWPUserPower装起来，方便JWebPower取用。 @see jweb.power.project.springboot._power.UserPower（拿出权限，传给JWebPower框架的类）
	 * 取权限的会话key=userPowerSession
	 * @param session 会话
	 * @param user  用户实例
	 */
	private void addSession(HttpSession session,User user) {
		//编号，从用户权限中拿出来，因为JWebPower框架 ，需要我们以数组方式传递，所以，我们对用户权限进行切割
		String[] code=null!=user.getSysCodes()&&!user.getSysCodes().isEmpty()
				?user.getSysCodes().split(","):null;
		String[] grades=null!=user.getSysGrades()&&!user.getSysGrades().isEmpty()
				?user.getSysGrades().split(","):null;
		//对接权限时，方便权限框架直接从会话key(userPowerSession)中，拿取用户权限。主要是为了提高效率
		session.setAttribute("userPowerSession", new JWPUserPower(grades,code));
	}
	
}
