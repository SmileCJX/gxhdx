package  com.gxhdx.dao;  

import com.gxhdx.entity.Academy;
import com.gxhdx.entity.Profession;
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
 * @ClassName: ProfessionDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("professionDao")
public class ProfessionDaoImpl extends BaseDao implements ProfessionDao {

	public Profession saveOrUpdate(final Profession entity) {
		entity.setModifyDate(new Date());
		Academy academy = new Academy();
		academy.setId(8L);
		entity.setAcademy(academy);
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_profession where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_profession where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Profession> findAll() {
		return super.find(Profession.class);
	}

	public PageDto<Profession> findList( String professionName,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Profession.class);
		
		
	  	if (!StringUtils.isEmpty(professionName)) {
			dc.add(Restrictions.like("professionName", professionName, MatchMode.ANYWHERE));
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
		List<Profession> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Profession>(total, pageNo, pageSize, list);
	}

	public Profession getProfession(Long id) {
		return super.get(Profession.class, id);
	}


}
