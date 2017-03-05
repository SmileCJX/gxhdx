package  com.gxhdx.dao;

import com.gxhdx.entity.Academy;
import com.gxhdx.entity.Profession;
import com.gxhdx.pageModel.PageProfession;
import com.gxhdx.support.PageDto;
import org.hibernate.criterion.*;
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

	public Profession saveOrUpdate(final Profession entity,Long academyId) {
		entity.setModifyDate(new Date());
		Academy academy = new Academy();
		academy.setId(academyId);
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

	public PageDto<Profession> findList(String professionName, Date startDate, Date endDate, Integer pageNo, Integer pageSize){
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

//		dc.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
//		dc.createAlias("academy","a",CriteriaSpecification.LEFT_JOIN);
		//模型转换
//		List<PageProfession> pageProfessions = new ArrayList<PageProfession>();
		List<Profession>  list = super.findByRootEntityCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
//		for(int i=0; i<list.size(); i++){
//			Academy academy = list.get(i).getAcademy();
//			System.out.println(academy.getAcademyName());
//			Profession profession = list.get(i);
//		}
//		BeanUtils.copyProperties(list,pageProfessions, new String[] { "" });
//		changeModel(pageProfessions,list);
		return new PageDto<Profession>(total, pageNo, pageSize, list);
	}

	private void changeModel(List<PageProfession> pageProfessions, List<Profession>  list){
//		if (list != null && list.size() > 0) {
//			for(int i=0; i<list.size(); i++){
//				PageProfession pageProfession = new PageProfession();
//				Object rows=list.get(i);
//				rows.
//				pageProfession.setId(list.get(i)[0]);
//				pageProfession.setProfessionName(professions.get(0).getProfessionName());
//				pageProfessions.add(pageProfession);
//			}

			for (Profession p : list) {
				//List<Tdepart> dl = t.getTdepart();//多表
				PageProfession pageProfession = new PageProfession();

				pageProfession.setAcademyName(p.getAcademy().getAcademyName());

				//BeanUtils.copyProperties(user, t, new String[] { "pwd" });字符串表示排除某些属性
				pageProfessions.add(pageProfession);
			}
//		}
	}

	public Profession getProfession(Long id) {
		return super.get(Profession.class, id);
	}


}
