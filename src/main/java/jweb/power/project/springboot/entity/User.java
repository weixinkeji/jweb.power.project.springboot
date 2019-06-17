package jweb.power.project.springboot.entity;

public class User {

	private Integer userId;
	private String userName;
	
	private String userAccount;
	private String userPassword;
	
	private String userIdImg;
	
	private String sysCodes;
	private String sysGrades;
	
	private String vipcode;
	
	private Integer vip;//1 表示 1年表示12个月
	
	public String getVipcode() {
		return vipcode;
	}

	public void setVipcode(String vipcode) {
		this.vipcode = vipcode;
	}

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
		user.setVipcode("VIP12");
		user.setVip(12);
		user.setUserIdImg("/static/_upload/image/u1.gif");
		return user;
	}
	
	
	
	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
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
