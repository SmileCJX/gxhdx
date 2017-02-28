package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.Department;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: DepartmentDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface DepartmentDao {

	public Department saveOrUpdate(Department article);

	public void del(Long id);

	public void delBatch(String ids);

	public Department getDepartment(Long id);

	public List<Department> findAll();

	public PageDto<Department> findList( String dno,   String name,   String ministerName,   String ministerPhone,   Integer totalPersons,   String description,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
