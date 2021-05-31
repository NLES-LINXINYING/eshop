package com.example.eshop.controller;

import com.example.eshop.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2021-05-27 20:38:00
 */
@Controller("userController")
@Scope("prototype")
//@RequestMapping("/user")
public class UserController extends BaseController<User> {

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		user = userService.login(user);
		if (user == null) {
			session.setAttribute("error", "登录失败");
			return "ulogin";
		} else {
			// 登录成功，将用户信息存到session中
			session.setAttribute("user", user);
			// 根据session中的goURL是否有值而决定页面的跳转
			String goURL = (String) session.getAttribute("goURL");
			if (goURL == null) {
				return "index";
			} else {
				return goURL;
			}
		}
	}
}
