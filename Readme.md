#演示项目的地址    
https://github.com/weixinkeji/jweb.power.project.springboot.git  
#分支【2.1_练习空白模板】     
是空白练习项目，方便小白练习JWebPower框架（当然，JWebPower框架，支持各种框架，不止一种Springboot。比如 国产的nutz,jfinal等，都 支持） 


#2.1 JWebPower框架，新增：

1、控制类下，public方法名即是编号的功能（有开关，需要要打开开关，方支持）   
2、增加对接类的 视图路径收集方法（只对 把返回视图，用注解 标在方法或类上的 web框架 。比如 nutz)   
3、增加对接类的，对于【一个方法绑定多个请求路径】的支持   

#功能调整
1、当检验事件失败后，监听类返回true（默认）,方能触发 失败事件。   （上个版本，无论返回什么，都会执行失败事件）

