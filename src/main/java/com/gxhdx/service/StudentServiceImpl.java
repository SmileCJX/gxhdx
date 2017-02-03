package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.StudentDao;
import com.gxhdx.entity.Student;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: StudentServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public Student saveOrUpdate(Student entity) {
		return studentDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		studentDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		studentDao.delBatch(ids);
	}

	@Transactional
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Transactional
	public PageDto<Student> findList( String studentName,   String sno,   String grade,   String academy,   String profession,   String classes,   String phone,   String email,   String role,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return studentDao.findList(studentName, sno, grade, academy, profession, classes, phone, email, role, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Student getStudent(Long id) {
		return studentDao.getStudent(id);
	}

}
