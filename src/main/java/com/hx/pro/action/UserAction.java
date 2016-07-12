package com.hx.pro.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hx.pro.entity.User;
import com.hx.pro.service.IBaseService;
import com.hx.pro.service.IUserService;
import com.hx.pro.util.Md5EncodeUtil;
import com.hx.pro.util.RandomUtil;
import com.hx.pro.util.SessionUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -2396115972212294492L;
	private String name;
	private String password;
	private User user;
	private String msg;
	private String inputCode;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBaseService baseService;

	/**
	 * 注册
	 * @throws Exception 
	 */
	public String signUp() throws Exception {
		String code = (String) SessionUtil.getSessionValue("1-23*");
		if (inputCode!=null&&!inputCode.equals("")) {
			if (inputCode.equals(code)) {
				String pwd_md5 = Md5EncodeUtil.encodeStr(password);
				user.setPass_wd(pwd_md5);
				user.setName_wd(name);
				baseService.saveOrUpdate(user, null, null);
			}
		}
		return "login";
	}
	
	/**
	 * 获取验证码
	 */
	public String validateCode() {
		inputCode = RandomUtil.createRandomCode(4);
		SessionUtil.setSessionValue("1-23*", inputCode);
		return Action.SUCCESS;
	}
	
	/**
	 * 登录
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public String signIn() throws Exception {
		List ulist_name = baseService.getListByHql("from User where name_wd = ?", name);
		if (ulist_name != null && ulist_name.size() > 0) {
			List ulist_bouth = baseService.getListByHql("from User where name_wd = ? and pass_wd = ?", name, Md5EncodeUtil.encodeStr(password));
			if (ulist_bouth != null && ulist_bouth.size() > 0) {
				msg = "登录成功";
				return "loginSuccess";
			} else {
				msg = "用户名或密码错误";
			}
		} else {
			msg = "该用户不存在";
		}
		return "login";
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
}
