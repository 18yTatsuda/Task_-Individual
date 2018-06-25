package jp.co.axiz.web.controller;

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
import jp.co.axiz.web.form.DeleteForm;
import jp.co.axiz.web.service.impl.ImageInfoService;

@Controller
public class DeleteController {

	@Autowired
	private SessionInfo sessionInfo;

	@Autowired
    MessageSource messageSource;

	@Autowired
	private ImageInfoService imageInfoService;

	@RequestMapping("/dalete")
	public String delete(@ModelAttribute("deleteForm") DeleteForm form,Model model) {
		return "delete";
	}

	@RequestMapping(value = "/deleteConfirm", method = RequestMethod.GET)
	public String deleteExecute(@Validated @ModelAttribute("deleteForm") DeleteForm form, BindingResult bindingResult,
			Model model) {

		int id = form.getImageId();

		imageInfoService.delete(id);

		model.addAttribute("image", sessionInfo.getLoginUser());

		return "deleteResult";
	}
}
