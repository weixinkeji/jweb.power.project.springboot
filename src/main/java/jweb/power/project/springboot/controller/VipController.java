package jweb.power.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jweb.power.project.springboot._power.listen.Vip12GradesListen;
import jweb.power.project.springboot._power.listen.YearListen;
import weixinkeji.vip.jweb.power.ann.JWPCode;
import weixinkeji.vip.jweb.power.ann.JWPCommon;
import weixinkeji.vip.jweb.power.ann.JWPDecorate;
import weixinkeji.vip.jweb.power.ann.JWPGrades;
import weixinkeji.vip.jweb.power.ann.JWPIgnoreDecorate;
import weixinkeji.vip.jweb.power.ann.JWPRegListen;

/**
 * @author wangchunzi
 */
@Controller
@RequestMapping("/vip")
public class VipController {
	
	@RequestMapping(path = "/v12plus", method = RequestMethod.GET)
	@ResponseBody
	@JWPGrades
	@JWPIgnoreDecorate
	@JWPRegListen(Vip12GradesListen.class)
	public String select_update() {
		return "selectOne";
	}
	
	
	@RequestMapping(path = "/b", method = RequestMethod.GET)
	@ResponseBody
	@JWPCode("b")
	@JWPIgnoreDecorate
	@JWPRegListen(YearListen.class)
	public String b() {
		return "selectOne";
	}
	
	@RequestMapping(path = "/a", method = RequestMethod.GET)
	@ResponseBody
	@JWPCode("a")
	@JWPIgnoreDecorate
	@JWPRegListen(YearListen.class)
	public String a() {
		return "selectOne";
	}
	
	
}
