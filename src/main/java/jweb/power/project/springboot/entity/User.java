package jweb.power.project.springboot.entity;

public class User {

	//主键
	private Integer userId;
	//用户名
	private String userName;
	//用户账号
	private String userAccount;
	//用户密码
	private String userPassword;
	//用户身份证
	private String userIdImg;
	
	//专门存放用户是否购买了vip礼包的
	private String vipPCode;
	
	//记录包年
	private Integer vipYear;
	
//--------------------------------------------------------------------------
	//用户权限编号 (假设多个编号间，以逗号隔开)
	private String sysCodes;
	//用户权限等级(假设多个等级间，以逗号隔开)
	private String sysGrades;
	
	

	/**
	 * 模拟用户登陆的数据 :用户1
	 * @param sysCodes  拥有的权限编号
	 * @param sysGrades 拥有的权限等级
	 * @return  User
	 */
	public static User getUser1(String sysCodes,String sysGrades) {
		User user=new User();
		user.setUserId(1);
		user.setSysCodes(sysCodes);
		user.setSysGrades(sysGrades);
		user.setUserName("我是用户1");
		user.setUserAccount("account1");
		user.setUserPassword("123");
		user.setUserIdImg("/static/_upload/image/u1.gif");
		user.setVipPCode("vipP12");
		user.setVipYear(12);
		return user;
	}
	

	/**
	 * 模拟用户登陆的数据 :用户2
	 * @param sysCodes  拥有的权限编号
	 * @param sysGrades 拥有的权限等级
	 * @return  User
	 */
	public static User getUser2(String sysCodes,String sysGrades) {
		User user=new User();
		user.setUserId(1);
		user.setSysCodes(sysCodes);
		user.setSysGrades(sysGrades);
		user.setUserName("我是用户2");
		user.setUserAccount("account2");
		user.setUserPassword("123");
		user.setUserIdImg("/static/_upload/image/u2.gif");
		return user;
	}
	
	public Integer getVipYear() {
		return vipYear;
	}

	public void setVipYear(Integer vipYear) {
		this.vipYear = vipYear;
	}
	public String getVipPCode() {
		return vipPCode;
	}


	public void setVipPCode(String vipPCode) {
		this.vipPCode = vipPCode;
	}


	public Integer getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserIdImg() {
		return userIdImg;
	}
	public String getSysCodes() {
		return sysCodes;
	}
	public String getSysGrades() {
		return sysGrades;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUserIdImg(String userIdImg) {
		this.userIdImg = userIdImg;
	}
	public void setSysCodes(String sysCodes) {
		this.sysCodes = sysCodes;
	}
	public void setSysGrades(String sysGrades) {
		this.sysGrades = sysGrades;
	}
	
	
	
}
