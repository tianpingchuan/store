package com.situ.store.cart.domain;

import java.io.Serializable;
import java.util.List;

public class CartParam implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Items> cartList;

	public List<Items> getCartList() {
		return cartList;
	}

	public void setCartList(List<Items> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "CartParam [cartList=" + cartList + "]";
	}
}
