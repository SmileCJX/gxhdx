package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.AcademyDao;
import com.gxhdx.entity.Academy;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: AcademyServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("academyService")
public class AcademyServiceImpl implements AcademyService {

	@Autowired
	private AcademyDao academyDao;

	@Transactional
	public Academy saveOrUpdate(Academy entity) {
		return academyDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		academyDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		academyDao.delBatch(ids);
	}

	@Transactional
	public List<Academy> findAll() {
		return academyDao.findAll();
	}

	@Transactional
	public PageDto<Academy> findList( String academyName,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return academyDao.findList(academyName, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Academy getAcademy(Long id) {
		return academyDao.getAcademy(id);
	}

}
