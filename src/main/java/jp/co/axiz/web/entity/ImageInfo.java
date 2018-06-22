package jp.co.axiz.web.entity;

import java.io.Serializable;

public class ImageInfo implements Serializable {
	private Integer imageId;
	private String imageName;
	private String path_name;
	private String file_name;
	private Integer tag_id;
	private String image_memo;
	private Integer user_id;
	private String privateFrag;


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
	public String getPath_name() {
		return path_name;
	}
	public void setPath_name(String path_name) {
		this.path_name = path_name;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public String getImage_memo() {
		return image_memo;
	}
	public void setImage_memo(String image_memo) {
		this.image_memo = image_memo;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getPrivateFrag() {
		return privateFrag;
	}
	public void setPrivateFrag(String privateFrag) {
		this.privateFrag = privateFrag;
	}


}
