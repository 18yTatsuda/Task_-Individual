package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.ImageInfo;

public interface IImagesDao {

	public List<ImageInfo> findByTags(Integer tag);
	public int register(ImageInfo image);
	public void update(ImageInfo image);
	public void delete(Integer id);
}
