package jweb.power.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jweb.power.project.springboot._power.listen.Grades12Plus;
import jweb.power.project.springboot._power.listen.Grades12PlusAndCode;
import weixinkeji.vip.jweb.power.ann.JWPCode;
import weixinkeji.vip.jweb.power.ann.JWPDecorate;
import weixinkeji.vip.jweb.power.ann.JWPGrades;
import weixinkeji.vip.jweb.power.ann.JWPIgnoreDecorate;
import weixinkeji.vip.jweb.power.ann.JWPRegListen;

/**
 *	1、方法与类 上的监听，相融合；<br>
 *  2、表达式上的监听自己相融合<br>
 *注：	方法与类   vs 表达式上:：监听是不兼容的. 如果方法或类上有监听。则不会再采用表达式上的<br>
 *	
 * @author wangchunzi
 *
 */
@Controller
@RequestMapping("/vip")
public class VipController {
	
	
	
	@JWPRegListen(Grades12Plus.class)
	@JWPGrades  //不写等级，表示只有拥有等级，都可以访问。+监听
	@RequestMapping(path = "/select", method = RequestMethod.GET)
	@ResponseBody
	public String select() {
		return "12+";
	}
	
	@JWPRegListen(Grades12PlusAndCode.class)
	@JWPGrades  //不写等级，表示只有拥有等级，都可以访问。+监听
	@RequestMapping(path = "/fuben", method = RequestMethod.GET)
	@ResponseBody
	public String fuben() {
		return "fuben";
	}
	
	@JWPCode("a")
	@RequestMapping(path = "/vip/time/a", method = RequestMethod.GET)
	@ResponseBody
	public String a() {
		return "a";
	}
	
	@JWPCode("b")
	@RequestMapping(path = "/vip/time/b", method = RequestMethod.GET)
	@ResponseBody
	public String b() {
		return "b";
	}
}
