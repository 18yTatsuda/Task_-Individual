package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.ImageInfo;
import jp.co.axiz.web.entity.SessionInfo;
import jp.co.axiz.web.form.InsertForm;
import jp.co.axiz.web.service.impl.ImageInfoService;

@Controller
public class InsertController {

	@Autowired
	private SessionInfo sessionInfo;

	@Autowired
	MessageSource message;

	@Autowired
	private ImageInfoService imageInfoService;

	@RequestMapping("/insert")
	public String insert(Model model) {
		return "insert";
	}

	@RequestMapping(value = "insert" ,method = RequestMethod.POST)
	public String insertExecute(@ModelAttribute("insertForm") InsertForm form, BindingResult bindingResult,
			Model model) {

		ImageInfo image = sessionInfo.getNewImage();

		int id = imageInfoService.insert(image);

		sessionInfo.setNewImage(null);

		form.setImageId(id);

		model.addAttribute("image",sessionInfo.getLoginUser());

		return "insertResult";
	}

}
