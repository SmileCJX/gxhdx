package  com.gxhdx.dao;  

import com.gxhdx.entity.ActivityType;
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
 * @ClassName: ActivityTypeDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("activityTypeDao")
public class ActivityTypeDaoImpl extends BaseDao implements ActivityTypeDao {

	public ActivityType saveOrUpdate(final ActivityType entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_activity_type where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_activity_type where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<ActivityType> findAll() {
		return super.find(ActivityType.class);
	}

	public PageDto<ActivityType> findList( String typeName,   String introduction,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(ActivityType.class);
		
		
	  	if (!StringUtils.isEmpty(typeName)) {
			dc.add(Restrictions.like("typeName", typeName, MatchMode.ANYWHERE));
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
		List<ActivityType> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<ActivityType>(total, pageNo, pageSize, list);
	}

	public ActivityType getActivityType(Long id) {
		return super.get(ActivityType.class, id);
	}


}
