package com.gxhdx.dao;

import com.gxhdx.entity.Role;
import com.gxhdx.entity.RolePermission;
import com.gxhdx.support.PageDto;

import java.util.List;

/**
 * @ClassName: RoleDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface RoleDao {

	public Role saveOrUpdate(Role role);

	public void del(Long id);

	public void delBatch(String ids);

	public void correlationPermissions(Long roleId, Long... permissionIds);

	public void uncorrelationPermissions(Long roleId, Long... permissionIds);

	public void uncorrelationAllPermissions(Long roleId);

	public Role getRole(Long id);

	public List<RolePermission> findRolePermssions(Long roleId);

	public List<Role> findAll();

	public List<String> findRoles();

	public PageDto<Role> findList(String desc, Integer pageNo, Integer pageSize);

}
