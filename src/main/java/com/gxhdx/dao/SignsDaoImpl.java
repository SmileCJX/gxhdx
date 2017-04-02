package  com.gxhdx.dao;  

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gxhdx.entity.Signs;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: SignsDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("signsDao")
public class SignsDaoImpl extends BaseDao implements SignsDao {

	public Signs saveOrUpdate(final Signs entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_signs where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_signs where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Signs> findAll() {
		return super.find(Signs.class);
	}

	public PageDto<Signs> findList( String title,   String applyName,   Boolean available,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Signs.class);
		
		
	  	if (!StringUtils.isEmpty(title)) {
			dc.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(applyName)) {
			dc.add(Restrictions.like("applyName", applyName, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(available)) {
			dc.add(Restrictions.eq("available", available));
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
		List<Signs> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Signs>(total, pageNo, pageSize, list);
	}

	public Signs getSigns(Long id) {
		return super.get(Signs.class, id);
	}


}
