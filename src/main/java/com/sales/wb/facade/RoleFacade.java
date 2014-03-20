package com.sales.wb.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.wb.entity.BillBookMaster;
import com.sales.wb.entity.Role;

/**
 * @author kbjani
 * 
 */
@Repository
public class RoleFacade implements AbstractDao<Role> {

	@Autowired
	private SessionFactory sessionFactory;

	public Long create(Role t) {
		return (Long) sessionFactory.getCurrentSession().save(t);
	}

	public Role get(Long id) {
		return (Role) sessionFactory.getCurrentSession().get(
				Role.class, id);
	}

	public List<Role> getAll() {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select g from Role g");
			List list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}