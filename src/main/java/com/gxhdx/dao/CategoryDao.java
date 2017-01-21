package com.gxhdx.dao;

import com.gxhdx.entity.Category;
import com.gxhdx.support.PageDto;

import java.util.List;

/** 
 * @ClassName: CategoryDao 
 * @Description: TODO(这里用一句话描述这个类的作用)
 *  
 */
public interface CategoryDao {

	public Category saveOrUpdate(Category category);

	public void del(Long id);

	public void delBatch(String ids);

	public Category getCategory(Long id);

	public Category getRootCategory();

	public List<Category> findAll();

	public PageDto<Category> findList(String name,String listType, Integer pageNo,Integer pageSize);

}
