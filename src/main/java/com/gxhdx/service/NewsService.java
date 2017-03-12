package com.gxhdx.service;

import com.gxhdx.entity.News;
import com.gxhdx.support.PageDto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: NewsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 */
public interface NewsService {

	public News saveOrUpdate(News entity);

	public void del(Long id);

	public void delBatch(String ids);

	public News getNews(Long id);

	public List<News> findAll();

	public PageDto<News> findList( String title,   String content,   String publisher,   String keyword,   String url,   String picurl,   Integer hits,  Date startDate,Date endDate,Integer pageNo, Integer pageSize,Boolean available);

}
