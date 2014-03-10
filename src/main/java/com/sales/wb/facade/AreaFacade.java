package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.AreaMaster;


@Repository
public class AreaFacade  implements AbstractDao<AreaMaster>{

	@Autowired
	private SessionFactory sessionFactory;
	public Long create(AreaMaster t) {		
		return (Long) sessionFactory.getCurrentSession().save(t);
	}

	public AreaMaster get(Long id) {
		return (AreaMaster) sessionFactory.getCurrentSession().get(AreaMaster.class, id);
	}

	public List<AreaMaster> getAll() {
		try{
			Query query= sessionFactory.getCurrentSession().createQuery("select g from AreaMaster g");
			List list= query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
