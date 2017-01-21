package com.gxhdx.dao;

import com.gxhdx.entity.Permission;
import com.gxhdx.support.PageDto;

import java.util.List;

/**
 * @ClassName: PermissionDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface PermissionDao {

	public Permission saveOrUpdate(Permission permission);

	public void del(Long permissionId);

	public void delBatch(String ids);

	public Permission getPermission(Long id);

	public Permission getRootPermission();

	public List<Permission> findAll();

	public PageDto<Permission> findList(String desc, Integer pageNo,
			Integer pageSize);

}
