package com.gxhdx.dao;

import com.gxhdx.entity.Comment;
import com.gxhdx.support.PageDto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: CommentDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface CommentDao {

	public Comment saveOrUpdate(Comment article);

	public void del(Long id);

	public void delBatch(String ids);

	public Comment getComment(Long id);

	public List<Comment> findAll();

	public PageDto<Comment> findList( String content,   String username,   Long activityId,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
