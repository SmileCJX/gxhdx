package com.gxhdx.dao;

import com.gxhdx.entity.Activity;
import com.gxhdx.support.PageDto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: ActivityDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface ActivityDao {

	public Activity saveOrUpdate(Activity article,Long department_id,Long activityType_id);

	public void del(Long id);

	public void delBatch(String ids);

	public Activity getActivity(Long id);

	public List<Activity> findAll();

	public PageDto<Activity> findList( String title,   String content,   String keyword,   String url,   String depatement,   String sponsor,   String sponsorPhone,   Integer hits,   String remark,   Boolean available,   String imgUrl,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

	public PageDto<Activity> findList(Long activityId, Boolean available, Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
