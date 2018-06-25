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
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.ImageInfo;
import jp.co.axiz.web.form.SelectForm;
import jp.co.axiz.web.service.impl.ImageInfoService;

@Controller
public class SelectController {

//	@Autowired
//	private SessionInfo sessionInfo;

	@Autowired
	MessageSource message;

	@Autowired
	private ImageInfoService ImageInfoService;

	@RequestMapping("/select")
	public String select(@ModelAttribute("selectForm") SelectForm form, Model model) {
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

		int tag =form.getTagId();

		List<ImageInfo> resultList = ImageInfoService.faindTag(tag);

		if(resultList.isEmpty()) {
			model.addAttribute("errmsg", errorMsg);
			return "select";
		}else {
			model.addAttribute("imagelist", resultList);
			return "selectResult";
		}
	}
	@RequestMapping("/details")
	public String details(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "details";
	}

	@RequestMapping(value = "/more" ,method = RequestMethod.POST)
	public String more(@ModelAttribute("selectForm") SelectForm form,Model model) {

		System.out.println(form.getImageId());
//		List<ImageInfo> moreImage = ImageInfoService.selectImage(form.getImageId());
		ImageInfo moreImage = ImageInfoService.findById(form.getImageId());
		model.addAttribute("image",moreImage);
		return "details";
	}
}
