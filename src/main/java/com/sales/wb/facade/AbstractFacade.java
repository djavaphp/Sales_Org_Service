package com.sales.wb.facade;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractFacade<T> {	
	public abstract void create(T entity);
	
	public abstract void edit(T entity);
	
	public abstract void remove(T entity);
	
	public abstract List<T> findAll();
	
	
}
