package com.gxhdx.service;

import com.gxhdx.dao.ProfessionDao;
import com.gxhdx.entity.Profession;
import com.gxhdx.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/** 
 * @ClassName: ProfessionServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("professionService")
public class ProfessionServiceImpl implements ProfessionService {

	@Autowired
	private ProfessionDao professionDao;

	@Transactional
	public Profession saveOrUpdate(Profession entity) {
		return professionDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		professionDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		professionDao.delBatch(ids);
	}

	@Transactional
	public List<Profession> findAll() {
		return professionDao.findAll();
	}

	@Transactional
	public PageDto<Profession> findList( String professionName,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return professionDao.findList(professionName, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Profession getProfession(Long id) {
		return professionDao.getProfession(id);
	}

}
