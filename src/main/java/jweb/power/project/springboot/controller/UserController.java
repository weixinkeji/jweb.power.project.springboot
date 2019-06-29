package jweb.power.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixinkeji.vip.jweb.power.ann.JWPCode;
import weixinkeji.vip.jweb.power.ann.JWPCommon;
import weixinkeji.vip.jweb.power.ann.JWPDecorate;
import weixinkeji.vip.jweb.power.ann.JWPIgnoreDecorate;

/**
 * @author wangchunzi
 */
//@JWPDecorate(codePrefix = "user:")
@Controller
@RequestMapping("/user")
//@JWPRegListen({BListen.class})
public class UserController {
	//监听跟我们的权限管理有区别。
	//对方法和类上的监听，如果有，会自动融合。
	//顺序 以方法的优先，再到类的。
	//另外，监听表达的不会参与进来。如果方法或类上已经有监听了
//	@JWPRegListen({AListen.class})
//	@JWPIgnoreDecorate
//	@JWPCode("select")
	@RequestMapping(path = "/select", method = RequestMethod.GET)
	@ResponseBody
	public String select() {
		return "select";
	}
	
//	@JWPCode("add")
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String add() {
		return "add";
	}
	@JWPCommon
	@RequestMapping(path = "/selectOne", method = RequestMethod.GET)
	@ResponseBody
	public String select_update() {
		return "selectOne";
	}
	
}
