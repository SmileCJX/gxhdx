package com.gxhdx.service;

import com.gxhdx.dao.CommentDao;
import com.gxhdx.entity.Comment;
import com.gxhdx.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/** 
 * @ClassName: CommentServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Transactional
	public Comment saveOrUpdate(Comment entity) {
		return commentDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		commentDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		commentDao.delBatch(ids);
	}

	@Transactional
	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	@Transactional
	public PageDto<Comment> findList( String content,   String username,   Long activityId,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return commentDao.findList(content, username, activityId, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public Comment getComment(Long id) {
		return commentDao.getComment(id);
	}

}
