package jweb.power.project.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jweb.power.project.springboot.entity.User;
import weixinkeji.vip.jweb.power.ann.JWPCode;

/**
 * 
 * @author wangchunzi
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(path = "/user/{u}/login", method = RequestMethod.GET)
	public String forwardTAdd(HttpSession session,@PathVariable int how) {
		//模拟 用户1登陆
		if(how==1) {
			session.setAttribute("userSession", User.getUser1("1,3", "3"));
		}else {
			session.setAttribute("userSession", User.getUser2("1,3", "3"));
		}
		return "index";
	}
	
}
