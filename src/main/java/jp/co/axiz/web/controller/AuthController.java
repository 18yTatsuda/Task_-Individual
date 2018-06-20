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
	public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
			Model model) {

		String errorMsg = message.getMessage("login.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg", errorMsg);
			return "login";
		}

		User user = userService.authentication(form.getUserName(), form.getPass());

		if (user == null) {
			model.addAttribute("errmsg", errorMsg);
			return "login";
		} else {
			sessionInfo.setLoginUser(user);
			model.addAttribute("user", sessionInfo.getLoginUser());
			return "menu";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		sessionInfo.invalidate();
		return "logout";
	}
}
