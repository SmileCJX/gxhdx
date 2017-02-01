package  com.gxhdx.dao;  

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gxhdx.entity.Activity;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: ActivityDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("activityDao")
public class ActivityDaoImpl extends BaseDao implements ActivityDao {

	public Activity saveOrUpdate(final Activity entity) {
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

	public PageDto<Activity> findList( String title,   String content,   Date activityStartDate,   Date activityEndDate,   Date applyStartDate,   Date applyEndDate,   String keyword,   String url,   String depatement,   String sponsor,   String sponsorPhone,   Integer hits,   String type,   String remark,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Activity.class);
		
		
	  	if (!StringUtils.isEmpty(title)) {
			dc.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(content)) {
			dc.add(Restrictions.like("content", content, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(activityStartDate)) {
			dc.add(Restrictions.eq("activityStartDate", activityStartDate));
		}
	  	if (!StringUtils.isEmpty(activityEndDate)) {
			dc.add(Restrictions.eq("activityEndDate", activityEndDate));
		}
	  	if (!StringUtils.isEmpty(applyStartDate)) {
			dc.add(Restrictions.eq("applyStartDate", applyStartDate));
		}
	  	if (!StringUtils.isEmpty(applyEndDate)) {
			dc.add(Restrictions.eq("applyEndDate", applyEndDate));
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
	  	if (!StringUtils.isEmpty(type)) {
			dc.add(Restrictions.eq("type", type));
		}
	  	if (!StringUtils.isEmpty(remark)) {
			dc.add(Restrictions.eq("remark", remark));
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
		List<Activity> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Activity>(total, pageNo, pageSize, list);
	}

	public Activity getActivity(Long id) {
		return super.get(Activity.class, id);
	}


}
