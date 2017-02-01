package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.Activity;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: ActivityDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface ActivityDao {

	public Activity saveOrUpdate(Activity article);

	public void del(Long id);

	public void delBatch(String ids);

	public Activity getActivity(Long id);

	public List<Activity> findAll();

	public PageDto<Activity> findList( String title,   String content,   Date activityStartDate,   Date activityEndDate,   Date applyStartDate,   Date applyEndDate,   String keyword,   String url,   String depatement,   String sponsor,   String sponsorPhone,   Integer hits,   String type,   String remark,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
