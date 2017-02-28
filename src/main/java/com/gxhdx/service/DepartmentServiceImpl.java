package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.DepartmentDao;
import com.gxhdx.entity.Department;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: DepartmentServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Transactional
	public Department saveOrUpdate(Department entity) {
		return departmentDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		departmentDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		departmentDao.delBatch(ids);
	}

	@Transactional
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Transactional
	public PageDto<Department> findList( String dno,   String name,   String ministerName,   String ministerPhone,   Integer totalPersons,   String description,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return departmentDao.findList(dno, name, ministerName, ministerPhone, totalPersons, description, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Department getDepartment(Long id) {
		return departmentDao.getDepartment(id);
	}

}
