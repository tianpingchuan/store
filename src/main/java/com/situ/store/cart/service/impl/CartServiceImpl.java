package com.situ.store.cart.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.store.base.domain.PageData;
import com.situ.store.cart.dao.CartDao;
import com.situ.store.cart.domain.Cart;
import com.situ.store.cart.service.CartService;
import com.situ.store.util.PageUtils;

@Service
public class CartServiceImpl implements CartService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CartDao cartDao;

	@Override
	public Long CartSave(Cart cart, String createBy) {
		cart.setActiveFlag(1);
		cart.setCreateBy(createBy);
		cart.setCreateDate(new Date());
		return cartDao.save(cart);
	}

	@Override
	public List<Cart> findByPage(Integer pageNo, Cart searchCart) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return cartDao.findByPage(searchCart, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Cart searchCart) {
		// 查询出数据总数
		Integer dataCount = cartDao.getCount(searchCart);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Cart findOneById(Long rowId) {
		return cartDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Cart cart, String createBy) {
		cart.setUpdateBy(createBy);
		cart.setUpdateDate(new Date());
		cartDao.update(cart);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		cartDao.delete(rowId);
		return 1;
	}

	@Override
	public List<Cart> findAll() {
		return cartDao.findAll();
	}

}
