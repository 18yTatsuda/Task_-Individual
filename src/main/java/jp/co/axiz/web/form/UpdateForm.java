package jp.co.axiz.web.form;

import javax.validation.constraints.NotNull;

public class UpdateForm {

	@NotNull
	private Integer imageId;

	private String newName;

	private Integer newTag;

	private String prevName;

	private Integer prevTag;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public Integer getNewTag() {
		return newTag;
	}

	public void setNewTag(Integer newTag) {
		this.newTag = newTag;
	}

	public String getPrevName() {
		return prevName;
	}

	public void setPrevName(String prevName) {
		this.prevName = prevName;
	}

	public Integer getPrevTag() {
		return prevTag;
	}

	public void setPrevTag(Integer prevTag) {
		this.prevTag = prevTag;
	}

	public boolean hasRequiredError() {
		return (newName == null || newName.isEmpty())
				|| (newTag == null);
	}
}
