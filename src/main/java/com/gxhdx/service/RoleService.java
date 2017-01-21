package com.gxhdx.service;

import com.gxhdx.entity.Role;
import com.gxhdx.entity.RolePermission;
import com.gxhdx.support.PageDto;

import java.util.List;

/**
 * @ClassName: RoleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface RoleService {

	public Role save(Role role, Long... permissionIds);

	public Role update(Role role, Long... permissionIds);

	public void delete(Long roleId);

	public void delBatch(String ids);

	public Role getRole(Long roleId);

	public List<RolePermission> findRolePermssions(Long roleId);

	public List<Role> findAll();

	public List<String> findRoles();

	public PageDto<Role> findList(String desc, Integer pageNo, Integer pageSize);

}
