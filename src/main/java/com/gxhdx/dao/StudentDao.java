package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.Student;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: StudentDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface StudentDao {

	public Student saveOrUpdate(Student article);

	public void del(Long id);

	public void delBatch(String ids);

	public Student getStudent(Long id);

	public List<Student> findAll();

	public PageDto<Student> findList( String studentName,   String sno,   String grade,   String academy,   String profession,   String classes,   String phone,   String email,   String role,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
