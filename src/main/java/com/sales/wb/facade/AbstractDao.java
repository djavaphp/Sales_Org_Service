package com.sales.wb.facade;

import java.util.List;

public interface AbstractDao<T> {
	Long create(T t);
	void update(T t);
	void delete(T t);
	T get(Long id);
	List<T> getAll();
}
