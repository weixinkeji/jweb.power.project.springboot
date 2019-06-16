package jweb.power.project.springboot._power.expression;

import java.util.Set;

import weixinkeji.vip.jweb.power.expresstion.JWPControllerURLExpresstion;

public class ControllerExpression  implements JWPControllerURLExpresstion{

	//公共区 0
	@Override
	public void setRequestURL_common(Set<String> set) {
		//完整路径写法
		set.add("/favicon.ico");
		//简化表达式
		// ** [./a-zA-Z0-9_-}{?=&]
		// *  [.a-zA-Z0-9_-}{?=&]
		//set.add(":**+user/*+");
		
		//采用java的正则表达式  
//		set.add("regex:[./a-zA-Z0-9_-}{?=&]+user/[.a-zA-Z0-9_-}{?=&]+");
		set.add("regex:[/a-zA-Z0-9]+user/[.a-zA-Z0-9]{1,4}");
	}
	//会话 1
	@Override
	public void setRequestURL_session(Set<String> set) {
		set.add("regex:[/a-zA-Z0-9]+user/[.a-zA-Z0-9]{1,4}");
	}
	
	//等级 2
	@Override
	public void setRequestURL_grades(Set<String> set) {
		set.add("regex:[/a-zA-Z0-9]+user/[.a-zA-Z0-9]{1,4} [[1,2]]");
	}

	//编号 2
	@Override
	public void setRequestURL_code(Set<String> set) {
		set.add("regex:[/a-zA-Z0-9]+user/[.a-zA-Z0-9]{1,4} [[add]]");
	}

}
