package com.situ.store.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.store.order.domain.Order;

@Repository
public interface OrderDao {

	List<Order> findAll();

	void delete(Long rowId);

	void update(Order order);

	Order get(Long rowId);

	Integer getCount(@Param("searchOrder") Order searchOrder);

	List<Order> findByPage(@Param("searchOrder") Order searchOrder, @Param("firstResult") Integer firstResult,
			@Param("maxResults") Integer maxResults);

	Long save(Order order);

	List<Order> findByIndentCode(String indentCode);

}
