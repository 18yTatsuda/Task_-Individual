package jp.co.axiz.web.form;

import javax.validation.constraints.NotBlank;

public class InsertForm {

	private Integer imageId;

	@NotBlank
	private String imageName;

	@NotBlank
	private String fileName;

	@NotBlank
	private Integer tagId;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public boolean isEmpty() {
		return (imageName == null || imageName.isEmpty())
				&& (fileName == null || fileName.isEmpty())
				&& (tagId == null);
	}
}
