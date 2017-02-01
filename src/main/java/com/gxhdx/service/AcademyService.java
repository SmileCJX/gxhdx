package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.Academy;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: AcademyService
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 */
public interface AcademyService {

	public Academy saveOrUpdate(Academy entity);

	public void del(Long id);

	public void delBatch(String ids);

	public Academy getAcademy(Long id);

	public List<Academy> findAll();

	public PageDto<Academy> findList( String academyName,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
