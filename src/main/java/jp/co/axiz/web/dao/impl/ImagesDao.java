package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.IImagesDao;
import jp.co.axiz.web.entity.ImageInfo;

@Repository
public class ImagesDao implements IImagesDao {

	 @Autowired
	    private NamedParameterJdbcTemplate nPjT;

	@Override
	public List<ImageInfo> findByTags(Integer tag) {
		String sql = "SELECT * FROM images WHERE tag_id = :tag";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("tag", tag);

		List<ImageInfo> resultList = nPjT.query(sql, param,new BeanPropertyRowMapper<ImageInfo>(ImageInfo.class));
		return resultList;
	}

//	@Override
//	public List<ImageInfo> selectImage(Integer imageId){
//		String sql ="SELECT i.image_id,i.image_name,i.file_name,t.tag_name,u.nickname,i.image_memo"
//				+"FROM images i JOIN tags t ON i.tag_id=t.tag_id JOIN users u ON i.user_id=u.user_id"
//				+"WHERE i.image_id = :imageId;";
//
//
//		MapSqlParameterSource param = new MapSqlParameterSource();
//		param.addValue("imageId", imageId);
//		List<ImageInfo> resultList = nPjT.query(sql, param, new BeanPropertyRowMapper<ImageInfo>(ImageInfo.class));
//		return resultList;
//	}


	@Override
	public List<ImageInfo> selectImage(Integer imageId){
		String sql ="SELECT i.image_id,i.image_name,i.file_name,t.tag_name,u.nickname,i.image_memo"
				+"FROM images i JOIN tags t ON i.tag_id=t.tag_id JOIN users u ON i.user_id=u.user_id"
				+"WHERE i.image_id = :imageId";


		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("imageId", imageId);
		List<ImageInfo> resultList = nPjT.query(sql, param, new BeanPropertyRowMapper<ImageInfo>(ImageInfo.class));
		return resultList;
	}

	public ImageInfo findById(Integer id) {
		String sql = "SELECT * FROM images WHERE image_id = :imageId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("imageId", id);

		List<ImageInfo> resultList = nPjT.query(sql, param, new BeanPropertyRowMapper<ImageInfo>(ImageInfo.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public int register(ImageInfo image) {
		String sql = "INSERT INTO images (image_name,file_name ,tag_id) VALUES (:imageName, :fileName, :tagId)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("imageName", image.getImageName());
		param.addValue("fileName", image.getFile_name());
		param.addValue("tag", image.getTag_id());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		nPjT.update(sql, param,keyHolder,new String[] {"image_id"});
		return keyHolder.getKey().intValue();
	}

	@Override
	public void update(ImageInfo image) {
		String sql = "UPDATE images SET image_name = :imageName, ,tag_id = :tagId, image_memo = :imageMemo WHERE image_id = :imageId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("imageName", image.getImageName());
		param.addValue("tagId", image.getTag_id());
		param.addValue("imageMemo", image.getImage_memo());
		param.addValue("imageId", image.getImageId());

		nPjT.update(sql, param);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM images WHERE image_id = :imageId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", id);

		nPjT.update(sql, param);
	}
}
