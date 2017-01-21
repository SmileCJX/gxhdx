package com.gxhdx.dao;

import java.util.List;

import com.gxhdx.entity.Article;
import com.gxhdx.support.PageDto;

/**
 * @ClassName: ArticleDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangp
 * @date 2016年6月27日 下午4:45:48
 * 
 */
public interface ArticleDao {

	public Article saveOrUpdate(Article article);

	public void del(Long id);

	public void delBatch(String ids);

	public Article getArticle(Long id);

	public List<Article> findAll();

	public PageDto<Article> findList(Long categoryId,String title, String tag, String remark,
			Integer pageNo, Integer pageSize);

}
