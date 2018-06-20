package jp.co.axiz.web.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.ImageInfo;
import jp.co.axiz.web.form.SelectForm;
import jp.co.axiz.web.service.IImageInfoService;

@Controller
public class SelectController {

	@Autowired
	MessageSource message;

	@Autowired
	private IImageInfoService ImageInfoService;

	@RequestMapping("/select")
	public String select(Model model) {
		return "select";
	}

	@RequestMapping(value = "/list")
	public String list(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
			Model model) {

		String errorMsg = message.getMessage("select.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg", errorMsg);
			return "select";
		}
		ImageInfo condition = new ImageInfo();
		condition.setTag_id(form.getTagId());

		List<ImageInfo> resultList = ImageInfoService.faindTag(condition);

		if(resultList.isEmpty()) {
			model.addAttribute("errmsg", errorMsg);
			return "select";
		}else {
			model.addAttribute("userlist", resultList);
			return "selectResult";
		}
	}
}
