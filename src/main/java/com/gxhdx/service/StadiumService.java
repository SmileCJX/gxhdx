package com.gxhdx.service;

import com.gxhdx.entity.Stadium;
import com.gxhdx.support.PageDto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: StadiumService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface StadiumService {

	public Stadium saveOrUpdate(Stadium entity);

	public void del(Long id);

	public void delBatch(String ids);

	public Stadium getStadium(Long id);

	public List<Stadium> findAll();

	public PageDto<Stadium> findList( String city,   String area,   String name,   String siteType,   String sod,   String lamplight,   String addr,   String openTime,   String siteInfo,   String contMan,   String contQQ,   String contQqun,   String contWx,   String contWb,   String contPhone,   Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
