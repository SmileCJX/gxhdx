package com.gxhdx.service;

import com.gxhdx.dao.SlideImgDao;
import com.gxhdx.entity.SlideImg;
import com.gxhdx.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SlideImgServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Service("slideImgService")
public class SlideImgServiceImpl implements SlideImgService {

	@Autowired
	private SlideImgDao slideImgDao;

	@Transactional
	public SlideImg saveOrUpdate(SlideImg entity) {
		return slideImgDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		slideImgDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		slideImgDao.delBatch(ids);
	}

	@Transactional
	public SlideImg getSlideImg(Long id) {
		return slideImgDao.getSlideImg(id);
	}

	@Transactional
	public List<SlideImg> findAll() {
		return slideImgDao.findAll();
	}

	@Transactional
	public PageDto<SlideImg> findList(String alt,Integer pageNo, Integer pageSize,Boolean available) {
		return slideImgDao.findList(alt,pageNo, pageSize, available);
	}

}
