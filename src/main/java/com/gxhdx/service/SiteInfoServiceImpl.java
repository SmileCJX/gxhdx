package com.gxhdx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxhdx.dao.SiteInfoDao;
import com.gxhdx.entity.SiteInfo;

/**
 * @ClassName: SiteInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Service("siteInfoService")
public class SiteInfoServiceImpl implements SiteInfoService {

	@Autowired
	private SiteInfoDao siteInfoDao;

	@Transactional
	public SiteInfo saveOrUpdate(SiteInfo entity) {
		return siteInfoDao.saveOrUpdate(entity);
	}

	@Transactional
	public SiteInfo getSiteInfo(Long id) {
		return siteInfoDao.getSiteInfo(id);
	}

}
