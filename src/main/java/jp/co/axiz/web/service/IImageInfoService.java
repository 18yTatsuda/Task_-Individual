package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.ImageInfo;

public interface IImageInfoService {

	public List<ImageInfo> faindTag(ImageInfo imageinfo);
	public ImageInfo findById(Integer id);
	public int insert(ImageInfo imageInfo);
	public void update(ImageInfo imageInfo);
	public void delete(Integer id);
}
