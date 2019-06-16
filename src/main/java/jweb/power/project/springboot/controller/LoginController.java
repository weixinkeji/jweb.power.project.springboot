package jweb.power.project.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jweb.power.project.springboot.entity.User;

/**
 * 
 * @author wangchunzi
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(path = "/user/{u}/login", method = RequestMethod.POST)
	public String forwardTAdd(HttpSession session,@PathVariable("u") Integer u) {
		//模拟 用户1登陆
		if(u==1) {
			session.setAttribute("userSession", User.getUser1("1,3", "3"));
		}else {
			session.setAttribute("userSession", User.getUser2("1,3", "3"));
		}
		return "index";
	}
	
}
