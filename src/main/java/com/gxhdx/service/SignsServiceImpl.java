package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.SignsDao;
import com.gxhdx.entity.Signs;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: SignsServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("signsService")
public class SignsServiceImpl implements SignsService {

	@Autowired
	private SignsDao signsDao;

	@Transactional
	public Signs saveOrUpdate(Signs entity) {
		return signsDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		signsDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		signsDao.delBatch(ids);
	}

	@Transactional
	public List<Signs> findAll() {
		return signsDao.findAll();
	}

	@Transactional
	public PageDto<Signs> findList( String title,   String applyName,   Boolean available,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return signsDao.findList(title, applyName, available, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Signs getSigns(Long id) {
		return signsDao.getSigns(id);
	}

}
