package com.gxhdx.dao;

import com.gxhdx.entity.Profession;
import com.gxhdx.support.PageDto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: ProfessionDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface ProfessionDao {

	public Profession saveOrUpdate(Profession article);

	public void del(Long id);

	public void delBatch(String ids);

	public Profession getProfession(Long id);

	public List<Profession> findAll();

	public PageDto<Profession> findList( String professionName,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
