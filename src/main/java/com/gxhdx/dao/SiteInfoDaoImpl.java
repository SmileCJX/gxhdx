package com.gxhdx.dao;

import com.gxhdx.entity.SiteInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: SiteInfoDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Component("siteInfoDao")
public class SiteInfoDaoImpl extends BaseDao implements SiteInfoDao {

	public SiteInfo saveOrUpdate(final SiteInfo entity) {
		super.saveOrUpdate(entity);
		return entity;
	}

	public SiteInfo getSiteInfo(Long id) {
		if (id == null) {
			List<SiteInfo> list = super.find(SiteInfo.class);
			if (list != null && list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} else {
			return super.get(SiteInfo.class, id);
		}
	}
}
