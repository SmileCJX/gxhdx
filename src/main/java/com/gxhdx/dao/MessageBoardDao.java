package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.MessageBoard;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: MessageBoardDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface MessageBoardDao {

	public MessageBoard saveOrUpdate(MessageBoard article);

	public void del(Long id);

	public void delBatch(String ids);

	public MessageBoard getMessageBoard(Long id);

	public List<MessageBoard> findAll();

	public PageDto<MessageBoard> findList( String phoneNumber,   String title,   String content,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
