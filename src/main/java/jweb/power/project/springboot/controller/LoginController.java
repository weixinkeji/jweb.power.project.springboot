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
@Controller
public class LoginController {
	
	@JWPCommon
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String forwardTAdd() {
		return "index";
	}
	@JWPCommon
	@RequestMapping(path = "/user/{u}/login", method = RequestMethod.POST)
	public String forwardTAdd(HttpSession session,@PathVariable("u") Integer u, String sysGrades, String sysCodes) {
		User user1;
		//模拟 用户1登陆
		if(u==1) {
			user1=User.getUser1(sysCodes,sysGrades );
			session.setAttribute("userSession", user1);
			
		}else {
			user1=User.getUser2(sysCodes,sysGrades );
			session.setAttribute("userSession", user1);
		}
		return "index";
	}
	
}
