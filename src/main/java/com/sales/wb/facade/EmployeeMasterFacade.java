package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.MstEmployee;
/**
*
* @author Kruti Jani
*/
@Repository
public class EmployeeMasterFacade implements AbstractDao<MstEmployee>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long  create(MstEmployee entity){		
		 return (Long) sessionFactory.getCurrentSession().save(entity);
		
	}
	
/*	public void update(MstEmployee entity){
		sessionFactory.getCurrentSession().update(entity);
	}
	
	public void delete(MstEmployee entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
*/	
	public List<MstEmployee> getAll(){
		try{
			Query q = sessionFactory.getCurrentSession().createQuery("select g from MstEmployee g"); 
			List list = q.list(); 
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	

	public MstEmployee get(Long id) {
		return (MstEmployee) sessionFactory.getCurrentSession().get(MstEmployee.class, id);
	}
}
