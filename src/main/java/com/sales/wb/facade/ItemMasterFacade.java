package com.sales.wb.facade;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.ItemMaster;

@Repository
public class ItemMasterFacade extends AbstractFacade<ItemMaster>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(ItemMaster entity){
		sessionFactory.getCurrentSession().save(entity);
	}
	
	public void edit(ItemMaster entity){
		sessionFactory.getCurrentSession().update(entity);
	}
	
	public void remove(ItemMaster entity){
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public List<ItemMaster> findAll(){
		try{
		return sessionFactory.getCurrentSession().createQuery("from item_master").list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	
}
