package jweb.power.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangchunzi
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	//拥有修改 、和查询  编号的人， 都可以访问此方法
	@RequestMapping(path = "/select", method = RequestMethod.GET)
	@ResponseBody
	public String select() {
		return "select";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String forwardTAdd() {
		return "add";
	}
	
}
