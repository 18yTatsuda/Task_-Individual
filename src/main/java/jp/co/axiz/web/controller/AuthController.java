package jp.co.axiz.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.SessionInfo;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.form.LoginForm;
import jp.co.axiz.web.form.UserInsertForm;
import jp.co.axiz.web.service.impl.UesrService;

@Controller
public class AuthController {

	@Autowired
	MessageSource message;

	@Autowired
	private SessionInfo sessionInfo;

	@Autowired
	private UesrService userService;

	@RequestMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String menu(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
			Model model) {

		String errorMsg = message.getMessage("login.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg", errorMsg);
			return "login";
		}

		User user = userService.authentication(form.getUserName(), form.getPassword());

		if (user == null) {
			model.addAttribute("errmsg", errorMsg);
			return "login";
		} else {
			sessionInfo.setLoginUser(user);
			model.addAttribute("user", sessionInfo.getLoginUser());
			return "menu";
		}
	}

	@RequestMapping("/regist")
	public String regist(@ModelAttribute("userInsertForm") UserInsertForm form, Model model) {
		return "regist";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(@Validated @ModelAttribute("userInsertForm") UserInsertForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			String errorMsg = message.getMessage("required.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "regist";
		}

		User user = new User();
		user.setUser_name(form.getUser_name());
		user.setPassword(form.getUser_pass());
		user.setNickName(form.getNickname());
		user.setEmail(form.getEmail());
		user.setMemo(form.getMemo());

		sessionInfo.setNewUser(user);

		if(!user.getPassword().equals(form.getConfirmPassword())) {
			String errorMsg = message.getMessage("password.not.match.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);

			form.setConfirmPassword("");

			return "regist";
		}

		int id = userService.insert(user);

		sessionInfo.setNewUser(null);

		form.setUserId(id);

		model.addAttribute("user",sessionInfo.getLoginUser());

		String msg = message.getMessage("registration.ok", null, Locale.getDefault());
		model.addAttribute("msg", msg);

		return "regist";
	}

	@RequestMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("user",sessionInfo.getLoginUser());
		return "profile";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		sessionInfo.invalidate();
		return "logout";
	}
}
