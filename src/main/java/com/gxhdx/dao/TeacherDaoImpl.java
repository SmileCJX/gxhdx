package  com.gxhdx.dao;  

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gxhdx.entity.Teacher;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: TeacherDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("teacherDao")
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	public Teacher saveOrUpdate(final Teacher entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_teacher where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_teacher where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Teacher> findAll() {
		return super.find(Teacher.class);
	}

	public PageDto<Teacher> findList( String teacherName,   String tno,   String academy,   String rank,   String research,   String honer,   String education,   String email,   String role,   String introduction,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		
		
	  	if (!StringUtils.isEmpty(teacherName)) {
			dc.add(Restrictions.like("teacherName", teacherName, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(tno)) {
			dc.add(Restrictions.eq("tno", tno));
		}
	  	if (!StringUtils.isEmpty(academy)) {
			dc.add(Restrictions.eq("academy", academy));
		}
	  	if (!StringUtils.isEmpty(rank)) {
			dc.add(Restrictions.eq("rank", rank));
		}
	  	if (!StringUtils.isEmpty(research)) {
			dc.add(Restrictions.like("research", research, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(honer)) {
			dc.add(Restrictions.like("honer", honer, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(education)) {
			dc.add(Restrictions.eq("education", education));
		}
	  	if (!StringUtils.isEmpty(email)) {
			dc.add(Restrictions.eq("email", email));
		}
	  	if (!StringUtils.isEmpty(role)) {
			dc.add(Restrictions.eq("role", role));
		}
	  	if (!StringUtils.isEmpty(introduction)) {
			dc.add(Restrictions.like("introduction", introduction, MatchMode.ANYWHERE));
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
		List<Teacher> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Teacher>(total, pageNo, pageSize, list);
	}

	public Teacher getTeacher(Long id) {
		return super.get(Teacher.class, id);
	}


}
