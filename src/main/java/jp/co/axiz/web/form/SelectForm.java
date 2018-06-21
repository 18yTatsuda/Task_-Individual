package jp.co.axiz.web.form;

public class SelectForm {

	private Integer tagId;

	private Integer imageId;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public boolean isEmpty() {
		return tagId == null;
	}
}
