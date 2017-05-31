package com.gxhdx.service;

import com.gxhdx.entity.Comment;
import com.gxhdx.support.PageDto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: CommentService
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 */
public interface CommentService {

	public Comment saveOrUpdate(Comment entity);

	public void del(Long id);

	public void delBatch(String ids);

	public Comment getComment(Long id);

	public List<Comment> findAll();

	public PageDto<Comment> findList( String content,   String username,   Long activityId,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
