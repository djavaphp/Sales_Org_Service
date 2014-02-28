package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.BillBookMaster;

/**
*
* @author Kruti Jani
*/
@Repository
public class BillBookFacade implements AbstractDao<BillBookMaster> {

	@Autowired
	private SessionFactory sessionFactory;
	public Long create(BillBookMaster t) {		
		return (Long) sessionFactory.getCurrentSession().save(t);
	}

	public BillBookMaster get(Long id) {
		return (BillBookMaster) sessionFactory.getCurrentSession().get(BillBookMaster.class, id);
	}

	public List<BillBookMaster> getAll() {
		try{
			Query query= sessionFactory.getCurrentSession().createQuery("select g from BillBookMaster g");
			List list= query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	

}
