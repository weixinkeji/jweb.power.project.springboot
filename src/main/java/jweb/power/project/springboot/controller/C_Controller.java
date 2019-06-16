package jweb.power.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixinkeji.vip.jweb.power.ann.JWPCode;

/**
 * 
 * @author wangchunzi
 *
 */
@JWPCode("a,b,c")
@Controller
//@JWPRegListen(HelloListen.class)
public class C_Controller {
	private int i=0;
	@RequestMapping(path = "c/forward/_test/ueditor/index?adsf=123", method = RequestMethod.GET)
	@ResponseBody
	public String forwardTAdd() {
		System.out.println(i++);
		return "_test/ueditor/index";
	}
	//@JWPSession
	//@JWPCode("1,3,3,add")
	@RequestMapping("c/forward/_test/{aa}/index")
	@ResponseBody
	public String forwardTAdd2() {
		return "_test/ueditor/index";
	}
}
