package jweb.power.project.springboot._power.expression;

import java.util.Set;



import weixinkeji.vip.jweb.power.expresstion.JWPControllerURLExpresstion;
//* <br>   **表示[点、斜杆、下划线、数字、大写小字母] （即会被替换成 [./a-zA-Z0-9_-}{?=&]）  
//* <br>   * 表达 26大小字母与0-9数字和下划线和一横杠（即会被替换成  [.a-zA-Z0-9_-}{?=&]）  
public class ControllerExpression implements JWPControllerURLExpresstion {

	
	//放行区0
	@Override
	public void setRequestURL_common(Set<String> set) {
		set.add("/favicon.ico");
//		set.add(":/user**+");//**
//		set.add("regex:/user[0-9a-zA-Z./]+");
	}

	//会话区1
	@Override
	public void setRequestURL_session(Set<String> set) {
//		set.add("regex:/user[0-9a-zA-Z./]+");
	}

	//等级区2
	@Override
	public void setRequestURL_grades(Set<String> set) {
//		set.add("regex:/user[0-9a-zA-Z./]+ [[1,3]]");
	}

	//编号区2
	@Override
	public void setRequestURL_code(Set<String> set) {
//		set.add("regex:/user[0-9a-zA-Z./]+ [[a,b]]");
	}

}
