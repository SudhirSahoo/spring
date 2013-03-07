package com.skumar.spring.core.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skumar.spring.core.domain.Associate;
import com.skumar.spring.core.domain.Task;

//@Transactional(
//	    propagation = Propagation.REQUIRED,
//	    isolation = Isolation.DEFAULT,
//	    readOnly = true)
public class HibernateTaskDAO extends HibernateDaoSupport implements TaskDAO {
	
	public Task getTask(Integer taskId) {
		System.out.println("DAO...");
		Task  task  = (Task) getHibernateTemplate().get(Task.class, taskId);
		return task;
	}
	
	
	public Integer createTask(Task task) {
        Integer taskId = (Integer)getHibernateTemplate().save(task);
        return taskId;
    }
	
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createTask(Task task, Associate associate) {
        Integer taskId = (Integer)getHibernateTemplate().save(task);
        Integer associateId = addAssociate(associate);
        
        return taskId + "  |  " + associateId;
    }
	
	public Integer createAssociate(Associate associate) {
		Integer associateId = (Integer) getHibernateTemplate().save(associate);
		
		String str = null;
		str.trim();
		return associateId;
	}
	
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Integer addAssociate(Associate associate) {
		Integer associateId = (Integer) getHibernateTemplate().save(associate);
		
		String str = null;
		str.trim();
		return associateId;
	}
}
