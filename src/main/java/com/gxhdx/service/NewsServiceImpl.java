package com.gxhdx.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.NewsDao;
import com.gxhdx.entity.News;
import com.gxhdx.support.PageDto;


/** 
 * @ClassName: NewsServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Transactional
	public News saveOrUpdate(News entity) {
		return newsDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		newsDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		newsDao.delBatch(ids);
	}

	@Transactional
	public List<News> findAll() {
		return newsDao.findAll();
	}

	@Transactional
	public PageDto<News> findList( String title,   String content,   String publisher,   String keyword,   String url,   String picurl,   Integer hits,  Date startDate,Date endDate,Integer pageNo, Integer pageSize) {
		return newsDao.findList(title, content, publisher, keyword, url, picurl, hits, startDate,endDate,pageNo,pageSize);
	}

	@Transactional
	public News getNews(Long id) {
		return newsDao.getNews(id);
	}

}
