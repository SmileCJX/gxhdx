package  com.gxhdx.dao;  

import com.gxhdx.entity.Department;
import com.gxhdx.support.PageDto;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: DepartmentDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("departmentDao")
public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {

	public Department saveOrUpdate(final Department entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_department where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_department where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Department> findAll() {
		return super.find(Department.class);
	}

	public PageDto<Department> findList( String dno,   String name,   String ministerName,   String ministerPhone,   Integer totalPersons,   String description,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Department.class);
		
		
	  	if (!StringUtils.isEmpty(dno)) {
			dc.add(Restrictions.eq("dno", dno));
		}
	  	if (!StringUtils.isEmpty(name)) {
			dc.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(ministerName)) {
			dc.add(Restrictions.like("ministerName", ministerName, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(ministerPhone)) {
			dc.add(Restrictions.like("ministerPhone", ministerPhone, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(totalPersons)) {
			dc.add(Restrictions.eq("totalPersons", totalPersons));
		}
	  	if (!StringUtils.isEmpty(description)) {
			dc.add(Restrictions.like("description", description, MatchMode.ANYWHERE));
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
		List<Department> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Department>(total, pageNo, pageSize, list);
	}

	public Department getDepartment(Long id) {
		return super.get(Department.class, id);
	}


}
