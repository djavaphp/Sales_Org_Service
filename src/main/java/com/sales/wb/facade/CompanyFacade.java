package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sales.wb.entity.CompanyMaster;

/**
*
* @author Kruti Jani
*/
@Repository
public class CompanyFacade implements AbstractDao<CompanyMaster> {

	@Autowired
	private SessionFactory sessionFactory;
	public Long create(CompanyMaster company) {
		return (Long)sessionFactory.getCurrentSession().save(company);
	}

	public CompanyMaster get(Long id) {
		return (CompanyMaster) sessionFactory.getCurrentSession().get(CompanyMaster.class, id);
	}

	public List<CompanyMaster> getAll() {
		try{
			Query q = sessionFactory.getCurrentSession().createQuery("select g from CompanyMaster g");
			List list = q.list(); 
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
