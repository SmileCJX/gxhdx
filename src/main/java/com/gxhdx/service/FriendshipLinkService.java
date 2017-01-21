package com.gxhdx.service;

import com.gxhdx.entity.FriendshipLink;
import com.gxhdx.support.PageDto;

import java.util.List;

/**
 * @ClassName: PermissionService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface FriendshipLinkService {

	public FriendshipLink saveOrUpdate(FriendshipLink entity);

	public void del(Long id);

	public void delBatch(String ids);

	public FriendshipLink getFriendshipLink(Long id);

	public List<FriendshipLink> findAll();

	public PageDto<FriendshipLink> findList(String siteName, Integer pageNo,
			Integer pageSize);
}
