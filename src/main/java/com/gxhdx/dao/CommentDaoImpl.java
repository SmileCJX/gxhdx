package  com.gxhdx.dao;  

import com.gxhdx.entity.Comment;
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
 * @ClassName: CommentDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("commentDao")
public class CommentDaoImpl extends BaseDao implements CommentDao {

	public Comment saveOrUpdate(final Comment entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_comment where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_comment where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<Comment> findAll() {
		return super.find(Comment.class);
	}

	public PageDto<Comment> findList( String content,   String username,   Long activityId,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(Comment.class);
		
		
	  	if (!StringUtils.isEmpty(content)) {
			dc.add(Restrictions.like("content", content, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(username)) {
			dc.add(Restrictions.like("username", username, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(activityId)) {
			dc.add(Restrictions.eq("activityId", activityId));
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
		List<Comment> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<Comment>(total, pageNo, pageSize, list);
	}

	public Comment getComment(Long id) {
		return super.get(Comment.class, id);
	}


}
