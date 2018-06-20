package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.impl.ImagesDao;
import jp.co.axiz.web.entity.ImageInfo;
import jp.co.axiz.web.service.IImageInfoService;

@Service
@Transactional
public class ImageInfoService implements IImageInfoService {

	@Autowired
	private ImagesDao imageInfoDao;

	@Override
	public List<ImageInfo> faindTag(ImageInfo imageInfo) {
		return imageInfoDao.findByTags(imageInfo.getTag_id());
	}

	public ImageInfo findById(Integer id) {
		return imageInfoDao.findById(id);
	}

	@Override
	public int insert(ImageInfo imageInfo) {
		return imageInfoDao.register(imageInfo);
	}

	@Override
	public void update(ImageInfo imageInfo) {
		imageInfoDao.update(imageInfo);
	}

	@Override
	public void delete(Integer imageId) {
		imageInfoDao.delete(imageId);
	}

}
