package com.situ.store.order.service;

import java.util.List;

import com.situ.store.base.domain.PageData;
import com.situ.store.order.domain.Order;

public interface OrderService {

	Long orderSave(Order order, String createBy);

	List<Order> findByPage(Integer pageNo, Order searchOrder);

	PageData buildPageData(Integer pageNo, Order searchOrder);

	Order findOneById(Long rowId);

	Integer doUpdate(Order order, String createBy);

	Integer doDelete(Long rowId);
	
	List<Order> findAll();

}
