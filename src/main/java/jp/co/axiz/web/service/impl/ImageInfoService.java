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
	public List<ImageInfo> faindTag(Integer tag) {
		return imageInfoDao.findByTags(tag);
	}

	@Override
	public ImageInfo findById(Integer id) {
		return imageInfoDao.findById(id);
	}

	@Override
	public ImageInfo selectImage(Integer tag) {
		return imageInfoDao.selectImage(tag);
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
