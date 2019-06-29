package jweb.power.project.springboot._power.listen;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weixinkeji.vip.jweb.power.ann.JWPRegListenUrl;
import weixinkeji.vip.jweb.power.listen.JWPListenInterface;
import weixinkeji.vip.jweb.power.listen.ListenStatus;
import weixinkeji.vip.jweb.power.model.JWPControllerModel;
import weixinkeji.vip.jweb.power.vo.JWPUserPower;

//控制区：表达controllerUrl  排序controllerSort=0
//静态区：staticUrl:以前缀方式匹配， staticSort=0 排序
//@JWPRegListenUrl(
//		controllerUrl = {"regex:/user[/0-9a-zA-Z]+"},controllerSort = 1
//		,staticUrl = {"/static/_upload/image"},staticSort = 1
//		)
public class AListen implements JWPListenInterface {

	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" --------------  "+status.name());
		return true;
	}

}
