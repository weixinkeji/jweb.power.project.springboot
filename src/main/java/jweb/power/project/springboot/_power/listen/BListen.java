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


//@JWPRegListenUrl(
//		controllerUrl = {"regex:/user[/0-9a-zA-Z]+"},controllerSort = 2
//		,staticUrl = {"/static/_upload/image"},staticSort = 2
//		)
public class BListen implements JWPListenInterface {

	@Override
	public boolean doMethod(FilterChain chain, HttpServletRequest req, HttpServletResponse resp, String requestURL,
			JWPControllerModel powerModel, JWPUserPower powerCode, ListenStatus status)
			throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" --------------  "+status.name());
		return true;
	}

}
