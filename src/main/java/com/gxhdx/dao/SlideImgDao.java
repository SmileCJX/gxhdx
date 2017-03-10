package com.gxhdx.dao;

import com.gxhdx.entity.SlideImg;
import com.gxhdx.support.PageDto;

import java.util.List;

/**
 * @ClassName: SlideImgDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface SlideImgDao {

	public SlideImg saveOrUpdate(SlideImg entity);

	public void del(Long id);

	public void delBatch(String ids);

	public SlideImg getSlideImg(Long id);

	public List<SlideImg> findAll();

	public PageDto<SlideImg> findList(String alt,Integer pageNo, Integer pageSize,Boolean available);

}
