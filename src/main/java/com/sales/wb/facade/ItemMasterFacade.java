package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.ItemMaster;

@Repository
public class ItemMasterFacade implements AbstractDao<ItemMaster>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long  create(ItemMaster entity){		
		 return (Long) sessionFactory.getCurrentSession().save(entity);
		
	}
	
	public void update(ItemMaster entity){
		sessionFactory.getCurrentSession().update(entity);
	}
	
	public void delete(ItemMaster entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public List<ItemMaster> getAll(){
		try{
			Query q = sessionFactory.getCurrentSession().createQuery("select g from ItemMaster g"); 
			List list = q.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	

	public ItemMaster get(Long id) {
		return (ItemMaster) sessionFactory.getCurrentSession().get(ItemMaster.class, id);
	}	
}
