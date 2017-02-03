package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.TeacherDao;
import com.gxhdx.entity.Teacher;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: TeacherServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	@Transactional
	public Teacher saveOrUpdate(Teacher entity) {
		return teacherDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		teacherDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		teacherDao.delBatch(ids);
	}

	@Transactional
	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	@Transactional
	public PageDto<Teacher> findList( String teacherName,   String tno,   String academy,   String rank,   String research,   String honer,   String education,   String email,   String role,   String introduction,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return teacherDao.findList(teacherName, tno, academy, rank, research, honer, education, email, role, introduction, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Teacher getTeacher(Long id) {
		return teacherDao.getTeacher(id);
	}

}
