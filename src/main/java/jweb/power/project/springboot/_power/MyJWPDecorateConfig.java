package jweb.power.project.springboot._power;

import weixinkeji.vip.jweb.power.config.JWPDecorateConfig;

public class MyJWPDecorateConfig implements JWPDecorateConfig {

	@Override
	public String codePrefix(Class<?> c) {
		return this.substringSuffix(c.getSimpleName(),"Controller","_Controller").toLowerCase()+":";
	}
}
