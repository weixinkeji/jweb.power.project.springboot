package jweb.power.project.springboot._power.expression;

import java.util.Set;

import weixinkeji.vip.jweb.power.expresstion.JWPControllerURLExpresstion;

public class ControllerExpression implements JWPControllerURLExpresstion {

	//放行区0
	@Override
	public void setRequestURL_common(Set<String> set) {
		set.add("/favicon.ico");
	}

	//会话区1
	@Override
	public void setRequestURL_session(Set<String> set) {
	}

	//等级区2
	@Override
	public void setRequestURL_grades(Set<String> set) {
	}

	//编号区2
	@Override
	public void setRequestURL_code(Set<String> set) {
	}

}
