package com.situ.store.order.service;

import java.util.List;

import com.situ.store.base.domain.PageData;
import com.situ.store.cart.domain.Items;
import com.situ.store.order.domain.Order;
import com.situ.store.user.domain.User;

public interface OrderService {

	Long orderSave(Order order, String createBy);

	List<Order> findByPage(Integer pageNo, Order searchOrder);

	PageData buildPageData(Integer pageNo, Order searchOrder);

	Order findOneById(Long rowId);

	Integer doUpdate(Order order, String createBy);

	Integer doDelete(Long rowId);
	
	List<Order> findAll();

	Long addOrder(User user, List<Items> list);

	List<Order> findByIndentCode(String indentCode);

}
