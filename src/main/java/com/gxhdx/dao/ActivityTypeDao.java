package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.ActivityType;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: ActivityTypeDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface ActivityTypeDao {

	public ActivityType saveOrUpdate(ActivityType article);

	public void del(Long id);

	public void delBatch(String ids);

	public ActivityType getActivityType(Long id);

	public List<ActivityType> findAll();

	public PageDto<ActivityType> findList( String typeName,   String introduction,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
