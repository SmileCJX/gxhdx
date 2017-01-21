package com.gxhdx.service;

import com.gxhdx.entity.SiteInfo;

/**
 * @ClassName: SiteInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public interface SiteInfoService {

	public SiteInfo saveOrUpdate(SiteInfo article);

	public SiteInfo getSiteInfo(Long id);

}
