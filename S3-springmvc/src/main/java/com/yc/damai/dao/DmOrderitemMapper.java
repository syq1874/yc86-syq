package com.yc.damai.dao;

import java.util.List;

import com.yc.damai.bean.DmOrderitem;

public interface DmOrderitemMapper {

	List<DmOrderitem> selectAll();
	
	DmOrderitem selectById(int id);
	
	// 新增订单明细
	int insert(DmOrderitem doi);
}