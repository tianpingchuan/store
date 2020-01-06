package com.situ.store.order.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.store.base.domain.PageData;
import com.situ.store.order.dao.OrderDao;
import com.situ.store.order.domain.Order;
import com.situ.store.order.service.OrderService;
import com.situ.store.util.PageUtils;

@Service
public class OrderServiceImpl implements OrderService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Long orderSave(Order order, String createBy) {
		order.setActiveFlag(1);
		order.setCreateBy(createBy);
		order.setCreateDate(new Date());
		return orderDao.save(order);
	}

	@Override
	public List<Order> findByPage(Integer pageNo, Order searchOrder) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return orderDao.findByPage(searchOrder, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Order searchOrder) {
		// 查询出数据总数
		Integer dataCount = orderDao.getCount(searchOrder);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Order findOneById(Long rowId) {
		return orderDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Order order, String createBy) {
		order.setUpdateBy(createBy);
		order.setUpdateDate(new Date());
		orderDao.update(order);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		orderDao.delete(rowId);
		return 1;
	}

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}

}
