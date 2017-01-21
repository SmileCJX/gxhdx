package com.gxhdx.service;

import com.gxhdx.dao.ArticleDao;
import com.gxhdx.entity.Article;
import com.gxhdx.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/** 
 * @ClassName: ArticleServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
@Service("categoryService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Transactional
	public Article saveOrUpdate(Article entity) {
		return articleDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		articleDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		articleDao.delBatch(ids);
	}

	@Transactional
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Transactional
	public PageDto<Article> findList(Long categoryId,String title,String tag,String remark, Integer pageNo,
			Integer pageSize) {
		return articleDao.findList(categoryId,title,tag,remark, pageNo, pageSize);
	}

	@Transactional
	public Article getArticle(Long id) {
		return articleDao.getArticle(id);
	}

}
