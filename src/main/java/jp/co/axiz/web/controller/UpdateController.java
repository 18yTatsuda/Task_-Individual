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

import jp.co.axiz.web.entity.ImageInfo;
import jp.co.axiz.web.entity.SessionInfo;
import jp.co.axiz.web.form.UpdateForm;
import jp.co.axiz.web.service.impl.ImageInfoService;

@Controller
public class UpdateController {

	@Autowired
	private SessionInfo sessionInfo;

	@Autowired
    MessageSource messageSource;

	@Autowired
	private ImageInfoService imageInfoService;

	@RequestMapping("/update")
	public String update(Model model) {
		return "update";
	}

	@RequestMapping(value="/update" , method = RequestMethod.POST)
	public String updateExecute(@Validated @ModelAttribute("updateForm") UpdateForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasFieldErrors("imageId")) {
			String errorMsg = messageSource.getMessage("required.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "update";
		}

		ImageInfo image = imageInfoService.findById(form.getImageId());

		if(image == null) {
			String errorMsg = messageSource.getMessage("id.not.found.error", null, Locale.getDefault());
			model.addAttribute("errmsg", errorMsg);
			return "update";
		}

		sessionInfo.setPrevImage(image);

		form.setNewName(image.getImageName());
		form.setNewTag(image.getTag_id());

		imageInfoService.update(image);

		sessionInfo.setAfterImage(null);
		sessionInfo.setPrevImage(null);

		model.addAttribute("image", sessionInfo.getLoginUser());

		return "updateResult";
	}
}
