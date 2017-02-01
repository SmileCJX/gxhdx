package  com.gxhdx.dao;  

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gxhdx.entity.Academy;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: AcademyDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("academyDao")
public class AcademyDaoImpl extends BaseDao implements AcademyDao {

	public Academy saveOrUpdate(final Academy entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_academy where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_academy where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Academy> findAll() {
		return super.find(Academy.class);
	}

	public PageDto<Academy> findList( String academyName,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Academy.class);
		
		
	  	if (!StringUtils.isEmpty(academyName)) {
			dc.add(Restrictions.eq("academyName", academyName));
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
		List<Academy> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Academy>(total, pageNo, pageSize, list);
	}

	public Academy getAcademy(Long id) {
		return super.get(Academy.class, id);
	}


}
