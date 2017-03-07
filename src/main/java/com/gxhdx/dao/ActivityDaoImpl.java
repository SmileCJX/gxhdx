package  com.gxhdx.dao;  

import com.gxhdx.entity.Activity;
import com.gxhdx.entity.ActivityType;
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
 * @ClassName: ActivityDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("activityDao")
public class ActivityDaoImpl extends BaseDao implements ActivityDao {

	public Activity saveOrUpdate(final Activity entity,Long department_id,Long activityType_id) {
		Department department = new Department();
		department.setId(department_id);

		ActivityType activityType = new ActivityType();
		activityType.setId(activityType_id);

		entity.setDepartment(department);
		entity.setActivityType(activityType);

		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_activity where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_activity where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Activity> findAll() {
		return super.find(Activity.class);
	}

	public PageDto<Activity> findList( String title,   String content,   String keyword,   String url,   String depatement,   String sponsor,   String sponsorPhone,   Integer hits,   String remark,   Boolean available,   String imgUrl,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Activity.class);
		
		
	  	if (!StringUtils.isEmpty(title)) {
			dc.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(content)) {
			dc.add(Restrictions.like("content", content, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(keyword)) {
			dc.add(Restrictions.like("keyword", keyword, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(url)) {
			dc.add(Restrictions.like("url", url, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(depatement)) {
			dc.add(Restrictions.eq("depatement", depatement));
		}
	  	if (!StringUtils.isEmpty(sponsor)) {
			dc.add(Restrictions.eq("sponsor", sponsor));
		}
	  	if (!StringUtils.isEmpty(sponsorPhone)) {
			dc.add(Restrictions.eq("sponsorPhone", sponsorPhone));
		}
	  	if (!StringUtils.isEmpty(hits)) {
			dc.add(Restrictions.eq("hits", hits));
		}
	  	if (!StringUtils.isEmpty(remark)) {
			dc.add(Restrictions.eq("remark", remark));
		}
	  	if (!StringUtils.isEmpty(available)) {
			dc.add(Restrictions.eq("available", available));
		}
	  	if (!StringUtils.isEmpty(imgUrl)) {
			dc.add(Restrictions.eq("imgUrl", imgUrl));
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
		List<Activity> list = super.findByRootEntityCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Activity>(total, pageNo, pageSize, list);
	}

	public Activity getActivity(Long id) {
		return super.get(Activity.class, id);
	}


}
