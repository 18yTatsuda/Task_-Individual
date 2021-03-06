package jp.co.axiz.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jp.co.axiz.web.entity.ImageInfo;
import jp.co.axiz.web.entity.SessionInfo;
import jp.co.axiz.web.entity.User;
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
	public String insertExecute(@ModelAttribute("insertForm") @RequestParam("image")
			MultipartFile file,InsertForm form, BindingResult bindingResult,Model model) throws IOException {

		if (file.getSize() > 0) {
			System.out.println(file.getOriginalFilename());
		}

		ImageInfo image = sessionInfo.getNewImage();
		User user = sessionInfo.getLoginUser();

		image.setImageName(form.getImageName());
		image.setFile_name(file.getOriginalFilename());
		image.setTag_id(form.getTagId());
		image.setUser_id(user.getUserId());
		image.setImage_memo(form.getImageMemo());

		int id = imageInfoService.insert(image);

		sessionInfo.setNewImage(null);

		form.setImageId(id);

		model.addAttribute("newImage",sessionInfo.getLoginUser());

		return "insertResult";
	}

}
