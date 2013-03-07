package com.skumar.spring.core.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.skumar.spring.core.domain.Associate;

public class HibernateAssociateDAO extends HibernateDaoSupport implements AssociateDAO {

	public Integer createAssociate(Associate associate) {
		Integer associateId = (Integer) getHibernateTemplate().save(associate);
		
		String str = null;
//		str.trim();
		return associateId;
	}

}
