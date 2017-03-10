package com.gxhdx.dao;

import com.gxhdx.entity.SlideImg;
import com.gxhdx.support.PageDto;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: SlideImgDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("slideImgDao")
public class SlideImgDaoImpl extends BaseDao implements SlideImgDao {

	public SlideImg saveOrUpdate(final SlideImg entity) {
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String sql = "delete from sys_slide_img where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from sys_slide_img where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<SlideImg> findAll() {
		return super.find(SlideImg.class);
	}

	public PageDto<SlideImg> findList(String alt,Integer pageNo, Integer pageSize,Boolean available) {
		DetachedCriteria dc = DetachedCriteria.forClass(SlideImg.class);
		if (available!=null) {
			dc.add(Restrictions.eq("available", available));
		}
		if (alt != null) {
			dc.add(Restrictions.like("alt", alt, MatchMode.ANYWHERE));
		}
		dc.addOrder(Order.desc("showOrder"));
		/* 一定先取count值 */
		Long total = super.countByCriteria(dc);
		List<SlideImg> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<SlideImg>(total, pageNo, pageSize, list);
	}

	public SlideImg getSlideImg(Long id) {
		return super.get(SlideImg.class, id);
	}

}
