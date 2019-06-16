package jweb.power.project.springboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * SpringMVC配置，影响不到 Servlet相关配置
 * 
 * @author Server215
 *
 */
@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

	@Autowired
	private ServletContext servletContext;

	private static String realPath;

	/**
	 * yourPath所在项目的真实路径。注意，加上/前缀
	 * 
	 * @param yourPath
	 * @return
	 */
	public static String getRealPath(String yourPath) {
		if (null == yourPath || yourPath.isEmpty()) {
			return realPath;
		}
		return realPath + yourPath;
	}

	// 配置视图
	//
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		realPath = servletContext.getRealPath("");
		if (realPath.endsWith("/") || realPath.endsWith("\\")) {
			realPath = realPath.substring(0, realPath.length() - 1);
		}
		System.out.println("项目真实路径:" + realPath);

//		registry.jsp();
		System.out.println("视图配置启动成功.............");
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	// 自定义 路径 映射
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	// url->拦截器->Controller处理方法
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(new AdminHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");// 排除
	}

	// 校验开关
	@Override
	public Validator getValidator() {
		return new org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean();
	}
	//请求url 绑定请求的数据类型
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.mediaType("json", MediaType.APPLICATION_JSON_UTF8);
		configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
	}

	/**          
	 * 配置静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("=============================注册资源器成功=================================");
		registry.addResourceHandler("/static/**").addResourceLocations("/public", "/static/").setCachePeriod(31556926);
	}
//	
	//自定义类型转换
	@Override
	public  void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToDate());
		/*registry.addConverter(new StringToInt());*/
	}
}
class StringToDate implements Converter<String, Date> {


	@Override
	public Date convert(String source) {
		System.out.println("来自前端页面表单的值（String转Date类型触发）：" + source);
		if (null == source) {
			return null;
		}
		SimpleDateFormat sf=null;
		if(source.matches("^([0-9]{4}-[0-9]{2}-[0-9]{2})$")) {
			 sf= new SimpleDateFormat("yyyy-MM-dd");
		}else if(source.matches("^([0-9]{4}/[0-9]{2}/[0-9]{2})$")) {
			sf= new SimpleDateFormat("yyyy/MM/dd");
		}else {
			return null;
		}
		try {
			return sf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
