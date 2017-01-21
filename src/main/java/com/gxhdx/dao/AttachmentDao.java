package com.gxhdx.dao;

import java.util.Date;
import java.util.List;

import com.gxhdx.entity.Attachment;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: AttachmentDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangp
 * @date 2016年6月29日 下午1:58:07
 * 
 */
public interface AttachmentDao {

	public Attachment saveOrUpdate(Attachment attachment);

	public void del(Long id);

	public void delByUrl(String url);

	public void delBatch(String ids);

	public Attachment getAttachment(Long id);

	public List<Attachment> findAll();

	public List<String> findAttachments(String ids);

	public PageDto<Attachment> findList(Date startDate, Date endDate,String type,
			Integer pageNo, Integer pageSize);

}