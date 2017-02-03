package  com.gxhdx.dao;  

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gxhdx.entity.Student;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: StudentDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao {

	public Student saveOrUpdate(final Student entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_student where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_student where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Student> findAll() {
		return super.find(Student.class);
	}

	public PageDto<Student> findList( String studentName,   String sno,   String grade,   String academy,   String profession,   String classes,   String phone,   String email,   String role,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		
		
	  	if (!StringUtils.isEmpty(studentName)) {
			dc.add(Restrictions.like("studentName", studentName, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(sno)) {
			dc.add(Restrictions.eq("sno", sno));
		}
	  	if (!StringUtils.isEmpty(grade)) {
			dc.add(Restrictions.eq("grade", grade));
		}
	  	if (!StringUtils.isEmpty(academy)) {
			dc.add(Restrictions.eq("academy", academy));
		}
	  	if (!StringUtils.isEmpty(profession)) {
			dc.add(Restrictions.eq("profession", profession));
		}
	  	if (!StringUtils.isEmpty(classes)) {
			dc.add(Restrictions.like("classes", classes, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(phone)) {
			dc.add(Restrictions.like("phone", phone, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(email)) {
			dc.add(Restrictions.like("email", email, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(role)) {
			dc.add(Restrictions.eq("role", role));
		}
		if (startDate != null) {
			dc.add(Restrictions.ge("modifyDate", startDate));
		}
		if (endDate != null) {
			dc.add(Restrictions.le("modifyDate", endDate));
		}
		dc.addOrder(Order.desc("modifyDate"));
		/* 一定先取count值 */
		Long total = super.countByCriteria(dc);
		List<Student> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Student>(total, pageNo, pageSize, list);
	}

	public Student getStudent(Long id) {
		return super.get(Student.class, id);
	}


}
