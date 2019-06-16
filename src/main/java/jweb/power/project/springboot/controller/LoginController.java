package jweb.power.project.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jweb.power.project.springboot._power.listen.BListen;
import jweb.power.project.springboot.entity.User;
import weixinkeji.vip.jweb.power.ann.JWPCommon;
import weixinkeji.vip.jweb.power.ann.JWPRegListen;
import weixinkeji.vip.jweb.power.ann.JWPSession;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

/**
 * 
 * @author wangchunzi
 *
 */
@JWPCommon
@Controller
public class LoginController {
	
	@JWPRegListen(value= {BListen.class})
//	@JWPRegListen(ALLListen.class)
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String forwardTAdd() {
		return "index";
	}
	
	@RequestMapping(path = "/user/{u}/login", method = RequestMethod.POST)
	public String forwardTAdd(HttpSession session,@PathVariable("u") Integer u, String sysGrades, String sysCodes) {
		User user1;
		//模拟 用户1登陆
		if(u==1) {
			user1=User.getUser1(sysCodes,sysGrades );
			session.setAttribute("userSession", user1);
			
			//用户的 权限等级
			String[] grades=null!=user1.getSysGrades()
					&&!user1.getSysGrades().isEmpty()
					?user1.getSysGrades().split(","):null;
			//用户的 权限编号
			String[] code=null!=user1.getSysCodes()?user1.getSysCodes().split(","):null;
			session.setAttribute("userPowerSession2", new JWPUserPower(grades,code));
			
		}else {
			user1=User.getUser2(sysCodes,sysGrades );
			session.setAttribute("userSession", user1);
			//用户的 权限等级
			String[] grades=null!=user1.getSysGrades()?user1.getSysGrades().split(","):null;
			
			//用户的 权限编号
			String[] code=null!=user1.getSysCodes()?user1.getSysCodes().split(","):null;
			session.setAttribute("userPowerSession2", new JWPUserPower(grades,code));
			
		}
		return "index";
	}
	
}
