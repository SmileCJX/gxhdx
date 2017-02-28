package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.MessageBoardDao;
import com.gxhdx.entity.MessageBoard;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: MessageBoardServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("messageBoardService")
public class MessageBoardServiceImpl implements MessageBoardService {

	@Autowired
	private MessageBoardDao messageBoardDao;

	@Transactional
	public MessageBoard saveOrUpdate(MessageBoard entity) {
		return messageBoardDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		messageBoardDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		messageBoardDao.delBatch(ids);
	}

	@Transactional
	public List<MessageBoard> findAll() {
		return messageBoardDao.findAll();
	}

	@Transactional
	public PageDto<MessageBoard> findList( String phoneNumber,   String title,   String content,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return messageBoardDao.findList(phoneNumber, title, content, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public MessageBoard getMessageBoard(Long id) {
		return messageBoardDao.getMessageBoard(id);
	}

}
