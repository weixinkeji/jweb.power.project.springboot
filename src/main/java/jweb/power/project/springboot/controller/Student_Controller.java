package jweb.power.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weixinkeji.vip.jweb.power.ann.JWPCode;
import weixinkeji.vip.jweb.power.ann.JWPDecorate;
import weixinkeji.vip.jweb.power.ann.JWPGrades;
import weixinkeji.vip.jweb.power.ann.JWPIgnoreDecorate;

/**
 *	1、方法与类 上的监听，相融合；<br>
 *  2、表达式上的监听自己相融合<br>
 *注：	方法与类   vs 表达式上:：监听是不兼容的. 如果方法或类上有监听。则不会再采用表达式上的<br>
 *	
 * @author wangchunzi
 *
 */
//@JWPDecorate(codePrefix = "user:")
@Controller
@RequestMapping("/student")
public class Student_Controller {
	
	//拥有修改 、和查询  编号的人， 都可以访问此方法
	@JWPCode("select,update")
	@JWPGrades
	@RequestMapping(path = "/select", method = RequestMethod.GET)
	@ResponseBody
	public String select() {
		return "select";
	}
	@JWPIgnoreDecorate
//	@JWPRegListen(value= {CListen.class})
//	@JWPGrades("1,3")
	@JWPCode("add")
//	@JWPCommon
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String forwardTAdd() {
		return "add";
	}
	
}
