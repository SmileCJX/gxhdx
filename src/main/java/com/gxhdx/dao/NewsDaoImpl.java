package  com.gxhdx.dao;  

import java.util.List;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gxhdx.entity.News;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: NewsDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("newsDao")
public class NewsDaoImpl extends BaseDao implements NewsDao {

	public News saveOrUpdate(final News entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_news where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_news where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<News> findAll() {
		return super.find(News.class);
	}

	public PageDto<News> findList( String title,   String content,   String publisher,   String keyword,   String url,   String picurl,   Integer hits,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(News.class);
		
		
	  	if (!StringUtils.isEmpty(title)) {
			dc.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(content)) {
			dc.add(Restrictions.like("content", content, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(publisher)) {
			dc.add(Restrictions.eq("publisher", publisher));
		}
	  	if (!StringUtils.isEmpty(keyword)) {
			dc.add(Restrictions.like("keyword", keyword, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(url)) {
			dc.add(Restrictions.like("url", url, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(picurl)) {
			dc.add(Restrictions.like("picurl", picurl, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(hits)) {
			dc.add(Restrictions.eq("hits", hits));
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
		List<News> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<News>(total, pageNo, pageSize, list);
	}

	public News getNews(Long id) {
		return super.get(News.class, id);
	}


}
