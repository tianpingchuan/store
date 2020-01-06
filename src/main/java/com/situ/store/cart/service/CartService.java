package com.situ.store.cart.service;

import java.util.List;

import com.situ.store.base.domain.PageData;
import com.situ.store.cart.domain.Cart;

public interface CartService {

	Long CartSave(Cart cart, String createBy);

	List<Cart> findByPage(Integer pageNo, Cart searchCart);

	PageData buildPageData(Integer pageNo, Cart searchCart);

	Cart findOneById(Long rowId);

	Integer doUpdate(Cart cart, String createBy);

	Integer doDelete(Long rowId);

	List<Cart> findAll();
}
