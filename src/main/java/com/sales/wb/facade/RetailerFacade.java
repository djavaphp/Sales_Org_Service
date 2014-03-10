package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.RetailerMaster;

/**
 * @author kbjani
 *
 */
@Repository
public class RetailerFacade implements AbstractDao<RetailerMaster>{
	@Autowired
	private SessionFactory sessionFactory;
	public Long create(RetailerMaster t) {		
		return (Long) sessionFactory.getCurrentSession().save(t);
	}

	public RetailerMaster get(Long id) {
		return (RetailerMaster) sessionFactory.getCurrentSession().get(RetailerMaster.class, id);
	}

	public List<RetailerMaster> getAll() {
		try{
			Query query= sessionFactory.getCurrentSession().createQuery("select g from RetailerMaster g");
			List list= query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
