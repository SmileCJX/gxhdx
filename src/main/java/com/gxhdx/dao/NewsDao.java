package com.gxhdx.dao;

import java.util.List;
import java.util.Date;

import com.gxhdx.entity.News;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: NewsDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface NewsDao {

	public News saveOrUpdate(News article);

	public void del(Long id);

	public void delBatch(String ids);

	public News getNews(Long id);

	public List<News> findAll();

	public PageDto<News> findList( String title,   String content,   String publisher,   String keyword,   String url,   String picurl,   Integer hits,  Date startDate,Date endDate,Integer pageNo, Integer pageSize);

}
