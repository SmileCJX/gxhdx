package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.ActivityTypeDao;
import com.gxhdx.entity.ActivityType;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: ActivityTypeServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("activityTypeService")
public class ActivityTypeServiceImpl implements ActivityTypeService {

	@Autowired
	private ActivityTypeDao activityTypeDao;

	@Transactional
	public ActivityType saveOrUpdate(ActivityType entity) {
		return activityTypeDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		activityTypeDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		activityTypeDao.delBatch(ids);
	}

	@Transactional
	public List<ActivityType> findAll() {
		return activityTypeDao.findAll();
	}

	@Transactional
	public PageDto<ActivityType> findList( String typeName,   String introduction,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return activityTypeDao.findList(typeName, introduction, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public ActivityType getActivityType(Long id) {
		return activityTypeDao.getActivityType(id);
	}

}
