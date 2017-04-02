package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.Signs;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: SignsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 */
public interface SignsService {

	public Signs saveOrUpdate(Signs entity);

	public void del(Long id);

	public void delBatch(String ids);

	public Signs getSigns(Long id);

	public List<Signs> findAll();

	public PageDto<Signs> findList( String title,   String applyName,   Boolean available,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
