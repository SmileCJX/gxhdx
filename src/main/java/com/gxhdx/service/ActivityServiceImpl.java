package com.gxhdx.service;

import com.gxhdx.dao.ActivityDao;
import com.gxhdx.entity.Activity;
import com.gxhdx.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


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
	public Activity saveOrUpdate(Activity entity,Long department_id,Long activityType_id) {
		return activityDao.saveOrUpdate(entity,department_id,activityType_id);
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
	public PageDto<Activity> findList( String title,   String content,   String keyword,   String url,   String depatement,   String sponsor,   String sponsorPhone,   Integer hits,   String remark,   Boolean available,   String imgUrl,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return activityDao.findList(title, content, keyword, url, depatement, sponsor, sponsorPhone, hits, remark, available, imgUrl, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public PageDto<Activity> findList(Long activityId, Boolean available, Date startDate, Date endDate, Integer pageNo, Integer pageSize) {
		return activityDao.findList(activityId,available,startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Activity getActivity(Long id) {
		return activityDao.getActivity(id);
	}

}
