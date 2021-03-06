package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.Teacher;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: TeacherDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface TeacherDao {

	public Teacher saveOrUpdate(Teacher article);

	public void del(Long id);

	public void delBatch(String ids);

	public Teacher getTeacher(Long id);

	public List<Teacher> findAll();

	public PageDto<Teacher> findList( String teacherName,   String tno,   String academy,   String rank,   String research,   String honer,   String education,   String email,   String role,   String introduction,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
