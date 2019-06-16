package jweb.power.project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import weixinkeji.vip.jweb.power.JWPFilter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	
//	@Bean
//	public FilterRegistrationBean<JWPFilter> myFilter() {
//		FilterRegistrationBean<JWPFilter> registration = new FilterRegistrationBean<JWPFilter>();
//		registration.setFilter(new JWPFilter());
//		registration.addUrlPatterns("/*");
//		return registration;
//	}

}