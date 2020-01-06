package com.situ.store.cart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.store.cart.domain.Cart;

@Repository
public interface CartDao {

	Long save(Cart cart);

	List<Cart> findByPage(@Param("searchCart") Cart searchCart, @Param("firstResult") Integer firstResult,
			@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchCart") Cart searchCart);

	Cart get(Long rowId);

	void update(Cart cart);

	void delete(Long rowId);

	List<Cart> findAll();

}
