package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.ActivityDao;
import com.gxhdx.entity.Activity;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: ActivityServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Transactional
	public Activity saveOrUpdate(Activity entity) {
		return activityDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		activityDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		activityDao.delBatch(ids);
	}

	@Transactional
	public List<Activity> findAll() {
		return activityDao.findAll();
	}

	@Transactional
	public PageDto<Activity> findList( String title,   String content,   Date activityStartDate,   Date activityEndDate,   Date applyStartDate,   Date applyEndDate,   String keyword,   String url,   String depatement,   String sponsor,   String sponsorPhone,   Integer hits,   String type,   String remark,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return activityDao.findList(title, content, activityStartDate, activityEndDate, applyStartDate, applyEndDate, keyword, url, depatement, sponsor, sponsorPhone, hits, type, remark, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Activity getActivity(Long id) {
		return activityDao.getActivity(id);
	}

}
