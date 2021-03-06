package com.gxhdx.service;

import com.gxhdx.dao.CategoryDao;
import com.gxhdx.entity.Category;
import com.gxhdx.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CategoryServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Transactional
	public Category saveOrUpdate(Category entity) {
		return categoryDao.saveOrUpdate(entity);
	}

	@Transactional
	public void del(Long id) {
		categoryDao.del(id);
	}

	@Transactional
	public void delBatch(String ids) {
		categoryDao.delBatch(ids);
	}

	@Transactional
	public Category getRoot() {
		return categoryDao.getRootCategory();
	}

	@Transactional
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Transactional
	public PageDto<Category> findList(String name,String listType, Integer pageNo,
			Integer pageSize) {
		return categoryDao.findList(name,listType, pageNo, pageSize);
	}

	@Transactional
	public Category getCategory(Long id) {
		return categoryDao.getCategory(id);
	}

}
