package  com.gxhdx.dao;  

import com.gxhdx.entity.MessageBoard;
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
 * @ClassName: MessageBoardDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("messageBoardDao")
public class MessageBoardDaoImpl extends BaseDao implements MessageBoardDao {

	public MessageBoard saveOrUpdate(final MessageBoard entity) {
		entity.setModifyDate(new Date());
		super.saveOrUpdate(entity);
		return entity;
	}

	public void del(Long id) {
		String	sql = "delete from hdx_message_board where id=?";
		super.sqlUpdate(sql, id);
	}

	public void delBatch(String ids) {
		// 删除该数据
		String sql = "delete from hdx_message_board where id in  (" + ids + ")";
		super.sqlUpdate(sql);
	}

	public List<MessageBoard> findAll() {
		return super.find(MessageBoard.class);
	}

	public PageDto<MessageBoard> findList( String phoneNumber,   String title,   String content,  Date startDate,Date endDate,Integer pageNo, Integer pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(MessageBoard.class);
		
		
	  	if (!StringUtils.isEmpty(phoneNumber)) {
			dc.add(Restrictions.like("phoneNumber", phoneNumber, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(title)) {
			dc.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
	  	if (!StringUtils.isEmpty(content)) {
			dc.add(Restrictions.like("content", content, MatchMode.ANYWHERE));
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
		List<MessageBoard> list = super.findByCriteria(dc, (pageNo - 1) * pageSize,
				pageSize);
		return new PageDto<MessageBoard>(total, pageNo, pageSize, list);
	}

	public MessageBoard getMessageBoard(Long id) {
		return super.get(MessageBoard.class, id);
	}


}
