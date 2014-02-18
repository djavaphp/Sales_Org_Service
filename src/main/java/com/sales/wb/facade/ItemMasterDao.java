package com.sales.wb.facade;

import java.util.List;

import com.sales.wb.entity.ItemMaster;

public interface ItemMasterDao {
	public  void create(ItemMaster entity);
	public  void edit(ItemMaster entity);
	public  void remove(ItemMaster entity);
	public  List<ItemMaster> findAll();

}
